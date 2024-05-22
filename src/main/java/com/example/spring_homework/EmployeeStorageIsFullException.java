package com.example.spring_homework;

import org.springframework.web.bind.annotation.ResponseStatus;


public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Штат полон");
    }
}
