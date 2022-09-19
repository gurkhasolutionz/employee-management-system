package com.gs.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.employeemanagement.model.Employee;
import com.gs.employeemanagement.service.EmployeeService;

//controller @responsebody

//Postman for testing endpoint or api

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	//Get-- get the data
	//Post-- create a data
	//Put --- update a data
	//Delete -- delete a data;
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/name")
	public String getName() {
		return "Spring boot ";
	}
	
	@PostMapping("/employee")
	public String createEmployee(@RequestBody Employee employee) {
		
		empService.createEmployee(employee);
		return "Employee Saved";
		
		
	}
}
