package com.example.demo.dao;


import org.apache.ibatis.annotations.Param;
import com.example.demo.domain.User;
import org.springframework.stereotype.Repository;


/**
 * Created by vale on 17/6/10.
 */
@Repository
public interface UserDao {
    /**
     * 根据用户名、密码查验用户
     *
     * @param name 用户名
     * @param password 密码
     */
     User findUserInfo(@Param("name") String name,@Param("password") String password);
}
