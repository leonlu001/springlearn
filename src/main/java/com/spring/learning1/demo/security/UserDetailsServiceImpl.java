package com.spring.learning1.demo.security;

import com.spring.learning1.demo.Repository.UserRepository;
import com.spring.learning1.demo.domain.User;
import com.spring.learning1.demo.exception.UserIsExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(username);
        if (user == null) {
            throw new UserIsExistException("该用户不存在");
        }


        // 关于 UserDetailsService 和 User 对象之前的文章已经讲过.
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), emptyList());


    }
}
