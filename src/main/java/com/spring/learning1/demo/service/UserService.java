package com.spring.learning1.demo.service;

import com.spring.learning1.demo.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface UserService {

//    public User getUser() {
//        User user = new User();
//        user.setId(1);
//        user.setName("leon");
//        user.setPassword("abc123");
//        return user;
//    }
    User getUser();
    User getByUserName(String name);
    void save(User user);

    List<User> findAll();

    Page<User> findAll(Pageable pageable);

    void save(User[] users);
}
