package com.spring.learning1.demo;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.spring.learning1.demo.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setup(){
    }

    @Test
    public void test_hello() throws Exception{
        String result = testRestTemplate.getForObject("/user/hello",String.class);
        Assert.assertEquals("hello!",result);
    }

    @Test
    public void test_getUser() throws Exception{
        User user = testRestTemplate.getForObject("/user/get",User.class);
        Assert.assertEquals(1,user.getId());
        Assert.assertEquals("leon",user.getName());
        Assert.assertEquals("abc",user.getPassword());
    }

    @Test
    public void test_saveUser() throws Exception {
//        User[] users = new User[1];
//        users[0].setId(2);
//        users[0].setName("tom");
//        users[0].setPassword("tom");
//        users[1] = new User(0,"jerry","tom");
//        users[2] = new User(1,"colin","tom");

        User user = new User();
        user.setId(13);
        user.setName("terry");
        user.setPassword("123");
        ResponseEntity<String> response = testRestTemplate.postForEntity("/user",user,String.class);

        Assert.assertEquals(200,response.getStatusCodeValue());
        Assert.assertEquals("ok",response.getBody());
    }

    @Test
    public void test_saveUsers() throws Exception {
        User[] users = new User[3];
        users[0] = new User(17,"tom","123");
        users[1] = new User(10,"jerry","tom");
        users[2] = new User(11,"colin2","tom");

        ResponseEntity<String> response = testRestTemplate.postForEntity("/user/list",users,String.class);

        Assert.assertEquals(200,response.getStatusCodeValue());
        Assert.assertEquals("ok",response.getBody());
    }

    @Test
    public void hello_test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello!"));
    }

    @Test
    public void getUser_test() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/user/get"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String jsonStr = result.getResponse().getContentAsString();
        System.out.println(jsonStr);
    }

    @Test
    public void saveUser_test() throws Exception {
        User user = new User();
        user.setId(14);
        user.setName("terry");
        user.setPassword("123");

        String result = new GsonBuilder().create().toJson(user);


        mvc.perform(MockMvcRequestBuilders.post("/user")
                .header("Content-Type","application/json")
                .content(result))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
