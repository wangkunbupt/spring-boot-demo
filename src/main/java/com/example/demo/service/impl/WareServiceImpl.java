package com.example.demo.service.impl;

import com.example.demo.dao.WareDao;
import com.example.demo.domain.Ware;
import com.example.demo.service.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangkun26 on 2017/6/12.
 */
@Service
public class WareServiceImpl implements WareService{
    @Autowired
    private WareDao wareDao;

    @Cacheable(value = "demo-cache" ,key = "'selectAll'")
    public List<Ware> selectAll(){
        System.out.println("test--run without cache");
        return wareDao.selectAll();
    }

    //CacheEvit若只加value值不加key值，并不能保证Cacheable的同value值Cache被删除，而要指定要删的key
    @CacheEvict(value = "demo-cache", key = "'selectAll'" )
    public int insert(Integer id, String wareName, String descr){
        return wareDao.insert(id, wareName, descr);
    }

    @CacheEvict(value = "demo-cache", key = "'selectAll'")
    public int updateById(Integer id, String wareName, String descr){
        return wareDao.updateById(id, wareName, descr);
    }

    @CacheEvict(value = "demo-cache", key = "'selectAll'")
    public int deleteById(Integer id){
        return wareDao.deleteById(id);
    }

    //统计商品数量
    public int countWare(){
        return wareDao.countWare();
    }
    //删除特定商品
    public int deleteSpeWare(String condition){
        return wareDao.deleteSpeWare(condition);
    }

}
