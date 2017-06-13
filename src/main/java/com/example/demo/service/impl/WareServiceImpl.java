package com.example.demo.service.impl;

import com.example.demo.dao.WareDao;
import com.example.demo.domain.Ware;
import com.example.demo.service.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangkun26 on 2017/6/12.
 */
@Service
public class WareServiceImpl implements WareService{
    @Autowired
    private WareDao wareDao;

    public List<Ware> selectAll(){
        return wareDao.selectAll();
    }

    public int insert(Integer id, String wareName, String descr){
        return wareDao.insert(id, wareName, descr);
    }

    public int updateById(Integer id, String wareName, String descr){
        return wareDao.updateById(id, wareName, descr);
    }

    public int deleteById(Integer id){
        return wareDao.deleteById(id);
    }

}
