package com.springboot.BankingApp.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class AccountDto {
	
	private long accountNumber;
	@PositiveOrZero
	private double balance;
	@Pattern(regexp = "^(active|inactive)$", message = "Field must be either 'active' or 'inactive'")
	private String status;
	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountDto(long accountNumber, double balance, String status) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.status = status;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AccountDto [accountNumber=" + accountNumber + ", balance=" + balance + ", status=" + status + "]";
	}
	
}
