package com.spring.learning1.demo.exception;

import org.springframework.security.core.AuthenticationException;

public class UserIsExistException extends AuthenticationException {

    public UserIsExistException(String msg) {
        super(msg);
    }

    public UserIsExistException(String msg, Throwable t) {
        super(msg, t);
    }
}
