package com.springboot.BankingApp.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.BankingApp.dto.AccountDto;
import com.springboot.BankingApp.service.AccountService;

import jakarta.validation.Valid;

@RestController
public class AccountController {
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping("/account")
	public ResponseEntity<AccountDto> addAccount(@Valid @RequestBody AccountDto accuntDto){
		return new ResponseEntity<>(accountService.createAccount(accuntDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<AccountDto> getAccount(@PathVariable long accountNumber){
		AccountDto accountDto=accountService.findAccountByAccountNumber(accountNumber);
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/account/{accountNumber}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable long accountNumber,@Valid @RequestBody Map<String,Double> request){
		double amount=request.get("amount");
		
		AccountDto accountDto=accountService.deposit(accountNumber, amount);
		return ResponseEntity.ok(accountDto);
	}
	@PutMapping("/account/{accountNumber}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable long accountNumber,@Valid @RequestBody Map<String,Double> request){
		double amount=request.get("amount");
		
		AccountDto accountDto=accountService.withdraw(accountNumber, amount);
		return ResponseEntity.ok(accountDto);
	}
	
//	@PutMapping("/account/{accountNumber}/inactivate")
//	public ResponseEntity<AccountDto> inactivate(@PathVariable long accountNumber){
//		AccountDto accountDto=accountService.inactivateAccount(accountNumber);
//		return ResponseEntity.ok(accountDto);
//	}
}
