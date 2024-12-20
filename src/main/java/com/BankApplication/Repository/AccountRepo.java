package com.BankApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BankApplication.Entity.Account;

public interface AccountRepo extends JpaRepository<Account, Long> {
	List<Account> findByBalanceGreaterThan(double amount);
}
