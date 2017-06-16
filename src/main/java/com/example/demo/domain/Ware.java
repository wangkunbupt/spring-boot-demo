package com.example.demo.domain;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Created by wangkun26 on 2017/6/12.
 */
@Alias("Ware")
public class Ware implements Serializable{
    //在使用Redis缓存时，有需要把List<Ware>缓存的地方，报了无法序列化的异常，所以增加impl Serizalizable

    private Integer id;
    private String wareName;
    private String descr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getWareName() {
        return wareName;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString(){
        return "Ware [" + id +"] [" + wareName + "] [" + descr + "]";
    }
}
