package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)//官方文档中解释“SpringRunner is an alias for the SpringJUnit4ClassRunner”代替SJU4CR
@RunWith(SpringRunner.class)

//SpringApplicationConfiguration标记已过时，新的为SpringBootTest
//SpringBootTest 是只有需要一个比较完整的 Spring Boot 环境的时候（比如需要做集成测试，启动 EmbeddedWebApplicationContext 的时候）需要
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = DemoApplication.class)
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
