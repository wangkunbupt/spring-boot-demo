package com.example.demo.domain;

/**
 * Created by vale on 17/6/10.
 */
public class User {
    //用户名
    private String name;
    //年龄
    private Integer age;
    //密码
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
