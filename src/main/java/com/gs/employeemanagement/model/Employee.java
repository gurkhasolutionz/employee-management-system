package com.gs.employeemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



@Entity
@Table
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long emp_id;
	
	@Column
	@NotBlank(message="Firstname cannot be blank")
	private String firstName;
	
	@Column
	@NotBlank(message="lastname cannot be blank")
	private String lastName;
	
	@Column
	@Email(message="should be a proper email")
	private String email;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
}
