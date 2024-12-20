package com.BankApplication.Entity;

import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
//	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long id;
	@Column(name = "name", insertable = true)
	private String Name;
	@Column(name = "amount", insertable = true)
	private double balance;

	public String getPlace() {
		return Place;
	}

	public void setPlace(String place) {
		Place = place;
	}

	public long getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(long phoneno) {
		Phoneno = phoneno;
	}

	@Column(name = "Phoneno", insertable = true)
	private long Phoneno;
	@Column(name = "Place", insertable = true)
	private String Place;

	public Account() {
		this.id = generateRandomId();

	}

	public Account(String name, double amount, String place, long phoneno) {
		// super();
		this.id = generateRandomId();
		Name = name;
		balance = amount;
		Place = place;
		Phoneno = phoneno;
	}

	private long generateRandomId() {
		// TODO Auto-generated method stub
		return ThreadLocalRandom.current().nextLong(1000000000L, 9999999999L);
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public double getAmount() {
		return balance;
	}

	public void setAmount(double Balance) {
		balance = Balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", Name=" + Name + ", Amount=" + balance + "]";
	}

}
