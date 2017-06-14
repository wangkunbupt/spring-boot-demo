package com.example.demo.controller;

import com.example.demo.dao.WareDao;
import com.example.demo.domain.Ware;
import com.example.demo.service.WareService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
/**
 * Created by wangkun26 on 2017/6/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional    //测试完成后回滚
public class WareControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testShow() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/show"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testAdd() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/add")
                .param("wid","7").param("warename","ware7").param("descr","test"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testUpdate() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/update")
                .param("wid","2").param("warename","ware2").param("descr","test"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testDelete() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/delete")
                .param("wid","1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
