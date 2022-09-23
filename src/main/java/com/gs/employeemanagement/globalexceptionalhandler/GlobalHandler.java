package com.gs.employeemanagement.globalexceptionalhandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gs.employeemanagement.exception.EmployeeNotFoundException;



@RestControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler{
	@Override
	protected ResponseEntity<Object>	handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		
		List<FieldError> errors= ex.getFieldErrors();
		List<String> errs= new ArrayList<>();
		for(FieldError err: errors) {
			errs.add(err.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errs);
		
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> handleNotFoundEmployee(Exception ex){
		Map<String, String> errors= new HashMap<>();
		errors.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	

}
