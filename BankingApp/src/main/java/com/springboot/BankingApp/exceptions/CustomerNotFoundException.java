package com.springboot.BankingApp.exceptions;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String message) {
		super(message);
	}

}
