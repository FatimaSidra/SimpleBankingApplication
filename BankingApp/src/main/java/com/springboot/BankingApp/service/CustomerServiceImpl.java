package com.springboot.BankingApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.BankingApp.dto.CustomerDto;
import com.springboot.BankingApp.entity.Account;
import com.springboot.BankingApp.entity.Customer;
import com.springboot.BankingApp.exceptions.CustomerNotFoundException;
import com.springboot.BankingApp.mapper.AccountMapper;
import com.springboot.BankingApp.mapper.CustomerMapper;
import com.springboot.BankingApp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer=CustomerMapper.mapToCustomer(customerDto);
		Customer savedCustomer=customerRepository.save(customer);
		return CustomerMapper.mapToCustomerDto(savedCustomer);
	}


	@Override
	public CustomerDto findCustomer(int id) {
		Customer customer=customerRepository.findById(id).orElseThrow(
				()->new CustomerNotFoundException("No customer exists with the given id"));
		return CustomerMapper.mapToCustomerDto(customer);
	}


	@Override
	public CustomerDto update(int id, CustomerDto customerDto) {
		Customer existingCustomer=customerRepository.findById(id).orElseThrow(
				()->new CustomerNotFoundException("No customer exists with the given id"));
		
		existingCustomer.setName(customerDto.getName());
		existingCustomer.setContact(customerDto.getContact());
		existingCustomer.setAddress(customerDto.getAddress());
		existingCustomer.setAadharNumber(customerDto.getAadharNumber());
		List<Account> accounts=customerDto.getAccounts()
				.stream()
				.map(accountDto->AccountMapper.mapToAccount(accountDto)).collect(Collectors.toList());
		existingCustomer.setAccounts(accounts);
		
		Customer savedCustomer=customerRepository.save(existingCustomer);
		return CustomerMapper.mapToCustomerDto(savedCustomer);
	}

}
