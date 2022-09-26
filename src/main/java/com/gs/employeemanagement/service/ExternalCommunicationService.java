package com.gs.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.gs.employeemanagement.model.User;


@Service
public class ExternalCommunicationService {
	
	@Value("${spring.exteralurl}")
	private String url;

	
	@Autowired
	private RestTemplate restTemplate;
	
	public User[] getAllData() {
		
		ResponseEntity<User[]> apiData=restTemplate.getForEntity(url, User[].class);
		if(apiData.getStatusCode()==HttpStatus.OK) {
			User[] responseData= apiData.getBody();
			return responseData;
		}
		
		return null;
	}
	
}
