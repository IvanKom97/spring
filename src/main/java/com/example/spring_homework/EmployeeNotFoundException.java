package com.example.spring_homework;

import org.springframework.web.bind.annotation.ResponseStatus;


public class EmployeeNotFoundException extends RuntimeException {
    String param;

    public EmployeeNotFoundException(String param) {
        super("error: " + param);
    }
}
