package com.BankApplication.Service;

import com.BankApplication.Entity.Account;

public interface MoneyTransferService {
	public Account sendMoney(long SenderId, long ReciverId, Double Money);

}
