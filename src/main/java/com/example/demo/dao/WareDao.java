package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import com.example.demo.domain.Ware;

import java.util.List;

/**
 * Created by wangkun26 on 2017/6/12.
 */
public interface WareDao {

    List<Ware> selectAll();

    int insert(@Param("id") Integer id, @Param("wareName") String wareName, @Param("descr") String descr);

    int updateById(@Param("id") Integer id, @Param("wareName") String wareName, @Param("descr") String descr);

    int deleteById(@Param("id") Integer id);
}
