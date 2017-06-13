package com.example.demo.service;

import com.example.demo.domain.User;


/**
 * Created by vale on 17/6/10.
 */
public interface UserService {
    /*
    * 根据用户名密码查询
    * @param
    * */
    User findUserInfo(String name, String password);
}
