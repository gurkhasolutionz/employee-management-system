package com.gs.employeemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gs.employeemanagement.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
