package com.springboot.BankingApp.dto;

import java.util.List;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerDto {
	
	private int id;
	@NotBlank 
	private String name;
	@NotBlank 
	@Size(min=12,max=12)
	private String aadharNumber;
	@NotBlank 
	private String address;
	@Digits(integer=10, fraction=0, message="Value must be a 10-digit number")
	private long contact;
	private List<AccountDto> accounts;
	public CustomerDto() {
		super();
	}
	public CustomerDto(int id, String name, String aadharNumber, String address, long contact,
			List<AccountDto> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.aadharNumber = aadharNumber;
		this.address = address;
		this.contact = contact;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public List<AccountDto> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<AccountDto> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", aadharNumber=" + aadharNumber + ", address=" + address
				+ ", contact=" + contact + ", accounts=" + accounts + "]";
	}
	
}
