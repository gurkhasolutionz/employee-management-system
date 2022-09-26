package com.gs.employeemanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gs.employeemanagement.model.User;
import com.gs.employeemanagement.service.ExternalCommunicationService;

@RestController
@RequestMapping("/api")
public class ExternalCommunicationController {
	
	@Autowired
	private ExternalCommunicationService externalService;
	
	@GetMapping("/external")
	public ResponseEntity<?> getAllexternaldata() {
		System.out.print("controller");
		
		User[] users=externalService.getAllData();
		if(users.length>0) return ResponseEntity.status(HttpStatus.OK).body(users);
		 return ResponseEntity.status(HttpStatus.OK).body("No user data available");
	}

}
