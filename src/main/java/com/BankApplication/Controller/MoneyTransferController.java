package com.BankApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankApplication.Entity.Account;
import com.BankApplication.Service.MoneyTransferService;

@RestController
@RequestMapping("/MoneyTransfer")
public class MoneyTransferController {
	@Autowired
	MoneyTransferService service;

	@PutMapping("/SendMoney/{SenderId}/{ReciverId}/{Money}")
	public Account tranfer(@PathVariable long SenderId, @PathVariable long ReciverId, @PathVariable Double Money) {
		return service.sendMoney(SenderId, ReciverId, Money);
	}

}
	