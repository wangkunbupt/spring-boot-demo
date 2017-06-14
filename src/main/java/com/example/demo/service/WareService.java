package com.example.demo.service;

import com.example.demo.domain.Ware;

import java.util.List;

/**
 * Created by wangkun26 on 2017/6/12.
 */
public interface WareService {
    List<Ware> selectAll();

    int insert(Integer id, String wareName, String descr);

    int updateById(Integer id, String wareName, String descr);

    int deleteById(Integer id);

    //统计商品数量
    int countWare();
    //删除特定商品
    int deleteSpeWare(String condition);

}
