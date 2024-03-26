package com.springboot.BankingApp.mapper;

import com.springboot.BankingApp.dto.AccountDto;
import com.springboot.BankingApp.entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account=new Account(
			accountDto.getAccountNumber(),
			accountDto.getBalance(),
			accountDto.getStatus()
		);
		return account;
	}
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto(
			account.getAccountNumber(),
			account.getBalance(),
			account.getStatus()
		);
		return accountDto;
	}
}
