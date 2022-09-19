package com.gs.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.employeemanagement.model.Employee;
import com.gs.employeemanagement.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	public void createEmployee(Employee employee) {
		
		empRepo.save(employee);
	}

}
