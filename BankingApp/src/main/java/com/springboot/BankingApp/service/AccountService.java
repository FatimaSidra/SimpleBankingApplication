package com.springboot.BankingApp.service;

import com.springboot.BankingApp.dto.AccountDto;

public interface AccountService {
	AccountDto createAccount(AccountDto accountDto);
	AccountDto findAccountByAccountNumber(long accountNumber);
	AccountDto deposit(long id,double amount);
	AccountDto withdraw(long id,double amount);
	AccountDto inactivateAccount(long id);
}
