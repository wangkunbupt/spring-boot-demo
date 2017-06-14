package com.example.demo.domain;

import org.apache.ibatis.type.Alias;

/**
 * Created by wangkun26 on 2017/6/12.
 */
@Alias("Ware")
public class Ware {
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
