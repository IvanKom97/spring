package com.example.spring_homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/employee")
@SpringBootApplication
public class SpringHomeworkApplication {
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringHomeworkApplication.class, args);
	}

	@PostMapping(path = "/add")
	public List<Employee> add(@RequestParam String firstName,
							  @RequestParam String secondName) {
		employeeService.addToList(firstName, secondName);
		return employeeService.employeeList;
	}

	@DeleteMapping(path = "/remove")
	public List<Employee> remove(@RequestParam String name,
	                             @RequestParam String secondName) {
		employeeService.removeFromList(name, secondName);
		return employeeService.employeeList;
	}

	@GetMapping(path = "/find")
	public Employee search(@RequestParam String name,
						   @RequestParam String secName) {
		return employeeService.search(name, secName);
	}
}
