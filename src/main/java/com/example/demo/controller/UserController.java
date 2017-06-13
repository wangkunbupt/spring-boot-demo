package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by vale on 17/6/10.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView getUserInfo(@RequestParam(value = "name",required = true) String name,
                                    @RequestParam(value = "password",required = true) String password){
/*
        ModelAndView result = new ModelAndView("index");
        User user = userService.findUserInfo(name, password);
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge()"+user.getAge());
            //return "manage";
            result.addObject("user",user);
            result.setViewName("manage");
            return result;
        }
        return result;
*/
        Optional<User> userOptional = Optional.ofNullable(userService.findUserInfo(name, password));
        return userOptional.map(u->{
            System.out.println("user.getName():"+u.getName());
            logger.info("user.getAge()"+u.getAge());
            return new ModelAndView("manage").addObject("user",u);
        }).orElse(new ModelAndView("index"));
    }

}
