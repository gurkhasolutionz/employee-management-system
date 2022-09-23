package com.gs.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gs.employeemanagement.model.Employee;
import com.gs.employeemanagement.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo empRepo;

	public Employee createEmployee(Employee employee) {
		
		return empRepo.save(employee);
	}

	public Optional<Employee> getEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		return empRepo.findById(empId);
		
	}

	public Employee updateEmployee(Optional<Employee> existingEmployee, Employee employee) {
		// TODO Auto-generated method stub
		existingEmployee.get().setFirstName(employee.getFirstName());
		existingEmployee.get().setLastName(employee.getLastName());
		existingEmployee.get().setEmail(employee.getEmail());
		return empRepo.save(existingEmployee.get());
		
	}

	public void deleteEmployeeById(Long empId) {
		// TODO Auto-generated method stub
		empRepo.deleteById(empId);
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	public Optional<Employee> getEmployeeByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return empRepo.findEmployeeByFirstName(firstName);
	}

}
