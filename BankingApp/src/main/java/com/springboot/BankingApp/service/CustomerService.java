package com.springboot.BankingApp.service;

import com.springboot.BankingApp.dto.CustomerDto;

public interface CustomerService {
	CustomerDto createCustomer(CustomerDto customerDto);
	CustomerDto findCustomer(int id);
	CustomerDto update(int id,CustomerDto customerDto);
}
