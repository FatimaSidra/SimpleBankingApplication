package com.springboot.BankingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.BankingApp.dto.AccountDto;
import com.springboot.BankingApp.entity.Account;
import com.springboot.BankingApp.exceptions.AccountInactiveStatusException;
import com.springboot.BankingApp.exceptions.AccountNotFoundException;
import com.springboot.BankingApp.exceptions.InsufficientBalanceException;
import com.springboot.BankingApp.mapper.AccountMapper;
import com.springboot.BankingApp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto findAccountByAccountNumber(long accountNumber) {
		Account account=accountRepository.findById(accountNumber).orElseThrow(()->new AccountNotFoundException("No account found with given accountNumber"));
		return AccountMapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(long accountNumber, double amount) {
		Account account=accountRepository.findById(accountNumber).orElseThrow(()->new AccountNotFoundException("No account found with given accountNumber"));
		if(account.getStatus().equals("inactive")) {
			throw new AccountInactiveStatusException("The account is inactive - denied access");
		}
		double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	public AccountDto withdraw(long accountNumber, double amount) {
		Account account=accountRepository.findById(accountNumber).orElseThrow(
				()->new AccountNotFoundException("No account found with given accountNumber"));
		if(account.getStatus().equals("inactive")) {
			throw new AccountInactiveStatusException("The account is inactive - denied access");
		}
		double balance=account.getBalance();
		if(balance<amount) {
			throw new InsufficientBalanceException("Insuffient Banlanced!!");
		}
		balance-=amount;
		account.setBalance(balance);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto inactivateAccount(long accountNumber) {
		Account account=accountRepository.findById(accountNumber).orElseThrow(()->new AccountNotFoundException("No account found with given accountNumber"));
		account.setStatus("inactive");
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

}
