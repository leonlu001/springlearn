package com.spring.learning1.demo.Repository;

import com.spring.learning1.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByName(String name);
}
