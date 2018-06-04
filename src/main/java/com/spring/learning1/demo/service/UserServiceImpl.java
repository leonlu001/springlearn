package com.spring.learning1.demo.service;

import com.spring.learning1.demo.Repository.UserRepository;
import com.spring.learning1.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser() {

        User user = userRepository.findById(1).get();
        return user;
    }

    @Override
    public User getByUserName(String name) {
        User user = userRepository.findUserByName(name);
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
        userRepository.flush();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
       return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(User[] users) {
        for (User user : users) {
            userRepository.save(user);
        }
        //throw new RuntimeException();
    }
}
