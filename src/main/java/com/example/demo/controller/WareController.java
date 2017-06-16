package com.example.demo.controller;

import com.example.demo.domain.Ware;
import com.example.demo.service.WareService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Created by wangkun26 on 2017/6/12.
 */

@Controller
public class WareController {

    private Logger logger=Logger.getLogger(WareController.class);

    @Autowired
    private WareService wareService;

    @RequestMapping("/show")
    public ModelAndView showAllWare(){
        Optional<List<Ware>> listWareOption = Optional.ofNullable(wareService.selectAll());

        return listWareOption.map(lw->{
            return new ModelAndView("manage").addObject("wares",lw);
        }).orElse(new ModelAndView("manage"));
    }

    @RequestMapping("/add")
    public ModelAndView addWare(@RequestParam("wid") Integer wid,
                        @RequestParam("warename") String wareName,
                        @RequestParam("descr") String descr){
        OptionalInt addRes = OptionalInt.of(wareService.insert(wid, wareName, descr));

        return showAllWare();
    }

    @RequestMapping("/update")
    public ModelAndView updateWare(@RequestParam("wid") Integer wid,
                                   @RequestParam("warename") String wareName,
                                   @RequestParam("descr") String descr){
        OptionalInt updateRes = OptionalInt.of(wareService.updateById(wid, wareName, descr));

        return showAllWare();
    }

    @RequestMapping("/delete")
    public ModelAndView deleteWare(@RequestParam("wid") Integer wid){
        OptionalInt deleteRes = OptionalInt.of(wareService.deleteById(wid));

        return showAllWare();
    }
}
