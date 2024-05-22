package com.example.spring_homework;

import org.springframework.web.bind.annotation.ResponseStatus;


public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Такой человек уже существует в списке");
    }
}
