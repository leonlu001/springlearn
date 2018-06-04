package com.spring.learning1.demo.controller;

import com.spring.learning1.demo.Util.JSONResult;
import com.spring.learning1.demo.domain.User;
import com.spring.learning1.demo.security.AccountCredentials;
import com.spring.learning1.demo.security.JwtTokenUtil;
import com.spring.learning1.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

//    @Autowired
//    AuthService authService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/auth/login")
    public String Auth(@RequestBody AccountCredentials account) {
        if(userService.getByUserName(account.getUsername())!=null) {
            final String token = jwtTokenUtil.generateToken(account.getUsername());
            Map<String,String> map = new HashMap();
            map.put("token",token);
            return JSONResult.fillResultString(1,"ok",map);
        } else {
            return JSONResult.fillResultString(1,"uer not exist.",null);
        }

    }

    @PostMapping("/auth/signup")
    public void signUp(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
    }
}
