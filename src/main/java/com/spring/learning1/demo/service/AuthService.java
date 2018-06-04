package com.spring.learning1.demo.service;

import com.spring.learning1.demo.domain.User;

public interface AuthService {

    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
