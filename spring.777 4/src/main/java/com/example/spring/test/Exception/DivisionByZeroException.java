package com.example.spring.test.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class DivisionByZeroException {
    public DivisionByZeroException() {
    }
}
