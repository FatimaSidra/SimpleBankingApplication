package com.springboot.BankingApp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="my_generator")
	@SequenceGenerator(name="my_generator",sequenceName="my_sequence",initialValue=1100)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="aadhar_number")
	private String aadharNumber;
	@Column(name="address")
	private String address;
	@Column(name="contact")
	private long contact;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id")
	private List<Account> accounts;
	
	
	public Customer() {
		super();
	}
	public Customer(int id, String name, String aadharNumber, String address, long contact, List<Account> accounts) {
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
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", aadharNumber=" + aadharNumber + ", address=" + address
				+ ", contact=" + contact + ", accounts=" + accounts + "]";
	}
	
}
