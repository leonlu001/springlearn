package com.spring.learning1.demo.controller;

import com.spring.learning1.demo.domain.User;
import com.spring.learning1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    @ResponseBody
    public List<User> users() {
        List<User> list = userService.findAll();
        return list;
    }

    @RequestMapping(value = "/page/{num}", method = RequestMethod.GET)
    @ResponseBody
    public Page<User> pageUsers(@PathVariable int num,@PathParam("size") int size) {
        Pageable page = PageRequest.of(num,size);
        Page<User> pageUsers = userService.findAll(page);
        return  pageUsers;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public @ResponseBody String saveUser(@RequestBody User user) {
        userService.save(user);
        return "ok";
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public @ResponseBody String saveUser(@RequestBody User[] users) {
        userService.save(users);
        return "ok";
    }

    @RequestMapping("/hello")
    @ResponseBody
    String home(){
        return "hello!";
    }

    @RequestMapping("/get")
    @ResponseBody
    public User getUser(){
        return userService.getUser();
    }


}
