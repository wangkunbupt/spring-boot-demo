package com.example.demo;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
//@EnableScheduling
@EnableCaching
@MapperScan("com.example.demo.dao")
public class DemoApplication {

	private static Logger logger = Logger.getLogger(DemoApplication.class);

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	//Start Demo
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		logger.info("Spring Boot Start--OK");
	}

}
