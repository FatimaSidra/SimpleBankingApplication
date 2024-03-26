package com.springboot.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.BankingApp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
