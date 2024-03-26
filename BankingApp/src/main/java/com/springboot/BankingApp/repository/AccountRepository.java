package com.springboot.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.BankingApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{

}
