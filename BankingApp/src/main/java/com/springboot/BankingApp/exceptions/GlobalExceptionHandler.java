package com.springboot.BankingApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomeException(AccountNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleCustomeException(CustomerNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handleCustomeException(InsufficientBalanceException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AccountInactiveStatusException.class)
	public ResponseEntity<ErrorResponse> handleCustomeException(AccountInactiveStatusException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleCustomeException(MethodArgumentNotValidException ex){
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage("Enter the valid data");
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
