package com.springboot.BankingApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.BankingApp.dto.CustomerDto;
import com.springboot.BankingApp.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	private CustomerService customerService;
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/customer")
	public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto){
		return new ResponseEntity<>(customerService.createCustomer(customerDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable int id){
		CustomerDto customer=customerService.findCustomer(id);
		return ResponseEntity.ok(customer);
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<CustomerDto> updateCustomerDetails(@PathVariable int id,@Valid @RequestBody CustomerDto customerDto){
		CustomerDto customer=customerService.update(id, customerDto);
		return ResponseEntity.ok(customer);
	}
}
