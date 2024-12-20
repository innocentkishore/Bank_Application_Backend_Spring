package com.BankApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.BankApplication.Entity.Account;
import com.BankApplication.Repository.AccountRepo;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImp implements AccountService {
	@Autowired
	AccountRepo repo;
	@Override
	public Account createAccount(Account account) {
		Account accountsave = repo.save(account);
		return accountsave;
	}

	@Override
	public List<Account> displayallAccount() {
		List<Account> displayAccount = repo.findAll();
		return displayAccount;
	}

	@Override
	public Account getAccountbynumberAccount(long number) {
		Optional<Account> getAccountid = repo.findById(number);
		if (getAccountid.isEmpty()) {
			throw new RuntimeException("Number is not Present");
		}
		Account accountdiscover = getAccountid.get();
		return accountdiscover;

	}

	@Override
	public Account depositeAccount(long number, Double amount) {
		Optional<Account> depositeOptional = repo.findById(number);
		if (depositeOptional.isEmpty()) {
			throw new RuntimeException("Account is not Present");
		}
		Account getoptionalAccount = depositeOptional.get();
		Double total = getoptionalAccount.getAmount() + amount;
		getoptionalAccount.setAmount(total);
		repo.save(getoptionalAccount);
		return getoptionalAccount;
	}

	@Override
	public Account withdrawAccount(long number, Double amount) {
		Optional<Account> findOptional = repo.findById(number);
		if (findOptional.isEmpty()) {
			throw new RuntimeException("Account is not Present");
		}
		Account getAccount = findOptional.get();
		Double totatwithdraw = getAccount.getAmount() - amount;
		getAccount.setAmount(totatwithdraw);
		repo.save(getAccount);
		return getAccount;
	}

	@Override
	public void closeAccount(long id) {
		repo.deleteById(id);

	}

	@Override
	public List<Account> getAccountdeatilbyammount(Double amount) {
		List<Account> getAccount = repo.findByBalanceGreaterThan(amount);
		System.out.println("get....." + getAccount);
		return getAccount;
	}

}
