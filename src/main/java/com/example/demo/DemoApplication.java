package com.example.demo;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@SpringBootApplication
//@EnableAutoConfiguration
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
