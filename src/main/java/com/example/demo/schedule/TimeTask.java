package com.example.demo.schedule;

import com.example.demo.service.WareService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by wangkun26 on 2017/6/13.
 */
@Component
public class TimeTask {

    private static Logger logger = Logger.getLogger(TimeTask.class);

    @Autowired
    private WareService wareService;

    //1min
    public final static long ONE_MINUTE = 60 * 1000;
    public final static long THIRTY_SEC = 30 * 1000;
    public final static long TWENTY_FIVE_MINUTE = 25 * 1000;

    //delete condition
    public final static String conditionStr = "6";

    //定时统计商品数量
    @Scheduled(fixedDelay = TWENTY_FIVE_MINUTE)
    public void fixedDelayCountWareTask(){
        logger.info("统计商品数量任务启动一次-》商品总数："+wareService.countWare());
    }

    //定时删除特殊商品
    @Scheduled(fixedRate = THIRTY_SEC)
    public void fixedRateDeleteJob(){
        OptionalInt delRes = OptionalInt.of((wareService.deleteSpeWare(conditionStr)));
        logger.info("删除"+delRes.getAsInt()+"条描述内容包含[ " + conditionStr + " ]的商品");
    }

    //每天11点执行
    @Scheduled(cron = "0 0 11 * * ?")
    public void cronJob(){
        logger.info("11点定时任务启动一次");
    }
}
