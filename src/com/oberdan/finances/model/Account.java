package com.oberdan.finances.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ACCOUNTS")
public class Account {

	@Id
	@Column(name = "account_id", nullable = false)
	private Integer id;

	@Column(name = "bank", nullable = false)
	private Integer bank;

	@Column(name = "agency", nullable = false)
	private Integer agency;

	@Column(name = "holder", nullable = false)
	private String holder;

	@Column(name = "balance", nullable = false)
	private Double balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBank() {
		return bank;
	}

	public void setBank(Integer bank) {
		this.bank = bank;
	}

	public Integer getAgency() {
		return agency;
	}

	public void setAgency(Integer agency) {
		this.agency = agency;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", bank=" + bank + ", agency=" + agency + ", holder=" + holder + ", balance="
				+ balance + "]";
	}

}