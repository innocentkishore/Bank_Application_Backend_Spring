	package com.BankApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BankApplication.Entity.Account;
import com.BankApplication.Service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountService service;

	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createAccount = service.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
	}

	@GetMapping("/getAllAccount")
	public List<Account> getAllAccount() {
		List<Account> getallAccount = service.displayallAccount();
		return getallAccount;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getbyidAccount(@PathVariable("id") long id) {
		Account getAccount = service.getAccountbynumberAccount(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(getAccount);
	}

	@PutMapping("/deposit/{id}/{amount}")
	public Account deposite(@PathVariable Long id, @PathVariable Double amount) {
		Account accountdeposite = service.depositeAccount(id, amount);
		return accountdeposite;
	}

	@PutMapping("/withdraw/{id}/{amount}")
	public Account withdrawAccount(@PathVariable long id, @PathVariable Double amount) {
		Account accountwithdraw = service.withdrawAccount(id, amount);
		return accountwithdraw;
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable long id) {
		service.closeAccount(id);
	}

	@GetMapping("getDetailByAmount/{amount}")
	public List<Account> getAccounts(@PathVariable Double amount) {
		List<Account> getAccountdetail = service.getAccountdeatilbyammount(amount);
		return getAccountdetail;
	}

}
