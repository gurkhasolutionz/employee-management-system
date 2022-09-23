package com.gs.employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gs.employeemanagement.exception.EmployeeNotFoundException;
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
	
	// modify our existing appliction
	// create custom exception use those in the crud
	// global exception handler (validtion of the request)
	//100
	//20
	
	// ResponseEnity
	
	// status: 
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/name")
	public String getName() {
		return "Spring boot ";
	}
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody @Valid Employee employee) {
		
		Employee emp=empService.createEmployee(employee);
	
		return ResponseEntity.status(HttpStatus.OK).body(emp);
				
				
	}
	@GetMapping("/employee/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable Long empId) {
		Optional<Employee> emp=empService.getEmployeeById(empId);
		if(emp.isPresent()) {
		return ResponseEntity.status(HttpStatus.OK).body(emp);
		}
	throw new EmployeeNotFoundException("Employee with id "+ empId+ " not Found");
		
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<?> updateEmployee(@PathVariable Long empId,@RequestBody Employee employee) {
		 Optional<Employee> existingEmployee= empService.getEmployeeById(empId);
		 if(existingEmployee.isPresent()) {
			Employee emp= empService.updateEmployee(existingEmployee,employee);
			return ResponseEntity.status(HttpStatus.OK).body(emp);
		 }
		 throw new EmployeeNotFoundException("Employee with id "+empId +" not Found");
			
	
	}
	
	//delete the employee
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long empId) {
		try {
		empService.deleteEmployeeById(empId);
		return ResponseEntity.status(HttpStatus.OK).body("employeee with id "+empId+ " deleted successfully");
		} catch(Exception e) {
			throw new EmployeeNotFoundException("Employee with id "+ empId +" not Found");
			
		}
		
	}

	@GetMapping("/employee")
	public ResponseEntity<?> getAllEmployee() {
		List<Employee>emplist= empService.getAllEmployee();
		if(emplist.size()>0) {
		return ResponseEntity.status(HttpStatus.OK).body(emplist);
		}
		throw new EmployeeNotFoundException("Employee Not Found");
		
		
	}
	
	/// for request param
	@GetMapping("/employee/search")
	public ResponseEntity<?> getEmployeeByFirstName(@RequestParam(name="firstName" ,required=true) String firstName) {
		
		Optional<Employee> emp=empService.getEmployeeByFirstName(firstName);
		if(emp.isPresent()) {
		return ResponseEntity.status(HttpStatus.OK).body(emp);
		
		}
		throw new EmployeeNotFoundException("Employee with "+firstName+" not found");
	}
	
}
