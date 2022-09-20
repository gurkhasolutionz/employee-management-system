package com.gs.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gs.employeemanagement.model.Employee;
import com.gs.employeemanagement.service.EmployeeService;

//controller @responsebody

//Postman for testing endpoint or api

@RestController
@RequestMapping("/api")
public class EmployeeController {
	

	//Post-- create a data //yesterday
	// start
	//Get-- get the data
	//Put --- update a data
	//Delete -- delete a data;
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/name")
	public String getName() {
		return "Spring boot ";
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		return empService.createEmployee(employee);
				
	}
	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployee(@PathVariable Long empId) {
		return empService.getEmployeeById(empId);
		
	}
	
	@PutMapping("/employee/{empId}")
	public Employee updateEmployee(@PathVariable Long empId,@RequestBody Employee employee) {
		 Optional<Employee> existingEmployee= empService.getEmployeeById(empId);
		 if(existingEmployee.isPresent()) {
			return empService.updateEmployee(existingEmployee,employee);
		 }
		 return null;
	
	}
	
	//delete the employee
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable Long empId) {
		empService.deleteEmployeeById(empId);
		return "employeee with id "+empId+ " deleted successfully";
		
	}

	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return empService.getAllEmployee();
		
	}
	
	/// for request param
	@GetMapping("/employee/search")
	public Optional<Employee> getEmployeeByFirstName(@RequestParam(name="firstName" ,required=true) String firstName) {
		
		return empService.getEmployeeByFirstName(firstName);
		
	}
	
}
