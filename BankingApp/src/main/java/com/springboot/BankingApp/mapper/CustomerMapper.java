package com.springboot.BankingApp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.BankingApp.dto.AccountDto;
import com.springboot.BankingApp.dto.CustomerDto;
import com.springboot.BankingApp.entity.Account;
import com.springboot.BankingApp.entity.Customer;

public class CustomerMapper {
	public static Customer mapToCustomer(CustomerDto customerDto) {
		List<Account> accounts=customerDto.getAccounts().stream().map(accountDto->AccountMapper.mapToAccount(accountDto)).collect(Collectors.toList());
		Customer customer=new Customer(
				customerDto.getId(),
				customerDto.getName(),
				customerDto.getAadharNumber(),
				customerDto.getAddress(),
				customerDto.getContact(),
				accounts);
		return customer;
	}
	public static CustomerDto mapToCustomerDto(Customer customer) {
		List<AccountDto> accounts=customer.getAccounts().stream().map(account->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		CustomerDto customerDto=new CustomerDto(
				customer.getId(),
				customer.getName(),
				customer.getAadharNumber(),
				customer.getAddress(),
				customer.getContact(),
				accounts);
		return customerDto;
	}
}
