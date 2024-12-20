package com.BankApplication.Service;

import java.util.List;

import com.BankApplication.Entity.Account;

public interface AccountService {
	public Account createAccount(Account account);

	public List<Account> displayallAccount();

	public Account getAccountbynumberAccount(long number);

	public Account depositeAccount(long number, Double amount);

	public Account withdrawAccount(long number, Double amount);

	public void closeAccount(long number);

	public List<Account> getAccountdeatilbyammount(Double amount);

}
