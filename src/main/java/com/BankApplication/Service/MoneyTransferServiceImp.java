package com.BankApplication.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BankApplication.Entity.Account;
import com.BankApplication.Repository.AccountRepo;

@Service
public class MoneyTransferServiceImp implements MoneyTransferService {
	@Autowired
	AccountRepo repo;

	@Override
	public Account sendMoney(long SenderId, long ReciverId, Double Money) {
		Optional<Account> transferOptional = repo.findById(ReciverId);
		if (transferOptional.isEmpty()) {
			throw new RuntimeException("Account not Found");
		}
		Account transferAccount = transferOptional.get();
		Double Total = transferAccount.getAmount() + Money;
		transferAccount.setAmount(Total);
		repo.save(transferAccount);
		Optional<Account> balanceAccount = repo.findById(SenderId);
		Account BalanceSender = balanceAccount.get();
		Double totalsender = BalanceSender.getAmount() - Money;
		BalanceSender.setAmount(totalsender);
		repo.save(BalanceSender);
		return transferAccount;
	}

}
