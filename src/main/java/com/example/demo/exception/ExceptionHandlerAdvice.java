package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangkun26 on 2017/6/15.
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    //全局异常拦截器
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage",e.getMessage());
        return modelAndView;
    }
}
