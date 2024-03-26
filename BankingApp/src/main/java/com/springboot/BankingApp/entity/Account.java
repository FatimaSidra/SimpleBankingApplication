package com.springboot.BankingApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="my_generator")
	@SequenceGenerator(name="my_generator",sequenceName="my_sequence",initialValue=2010)
	@Column(name="account_number")
	private long accountNumber;
	@Column(name="balance")
	private double balance;
	@Column(name="status")
	private String status;
	
	public Account() {
		super();
	}
	
	public Account(long accountNumber, double balance, String status) {
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
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", status=" + status + "]";
	}
	
	
}
