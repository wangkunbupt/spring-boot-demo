package com.example.demo.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangkun26 on 2017/6/15.
 */
@Aspect
@Component
public class HttpAspect {

    private  Logger logger = Logger.getLogger(HttpAspect.class);

   @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void log(){}

   @Before("log()")
    public void beforeLog(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录请求url
        logger.info("url={" + request.getRequestURI() + "}");

        //请求ip
        logger.info("ip={" + request.getRemoteAddr() + "}");

        //url方法
        logger.info("method={" + request.getMethod() + "}");

        //调用方法
        logger.info("class_method={" +joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName()+"}");
        //参数
        logger.info("class_args={"+joinPoint.getArgs()+"}");

    }

}
