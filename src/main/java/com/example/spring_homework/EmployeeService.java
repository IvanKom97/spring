package com.example.spring_homework;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final static int numberEmployees = 10;
    List<Employee> employeeList = new ArrayList<>(numberEmployees);


    public List<Employee> addToList(String name, String secondName) {
        Employee employee = new Employee(name, secondName);
        if (employeeList.size() > numberEmployees) {

            throw new EmployeeStorageIsFullException();
        }
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } employeeList.add(employee);
        return employeeList;
    }

    public List<Employee> removeFromList(String name, String secondName) {
        Employee employee = new Employee(name, secondName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("Такого работника: " + employee.toString() + " не существует");
        }
        for (Employee e : employeeList) {
            if (e.equals(employee)) {
                 employeeList.remove(e);
                return employeeList;
            }
        }return employeeList;
    }

    public Employee search(String name, String secondName) {
        Employee employee = new Employee(name, secondName);
        if (!employeeList.contains(employee)) {
            throw new EmployeeNotFoundException("Такого работника: " + employee.toString() + " не существует");
        }
        if (employeeList.contains(employee)) {
            return employee;
        }
        return employee;
    }
}
