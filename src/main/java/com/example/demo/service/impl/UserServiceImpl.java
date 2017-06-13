package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vale on 17/6/10.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public User findUserInfo(String name,String password){
        User user=userDao.findUserInfo(name, password);
        return user;
    }
}
