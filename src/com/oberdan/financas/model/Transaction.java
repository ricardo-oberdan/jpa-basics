package com.oberdan.financas.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.oberdan.financas.enums.TransactionType;

@Entity(name = "TRANSACTIONS")
@SequenceGenerator(name = "TRANSACTION_GENERATOR", sequenceName = "TRANSACTION_SEQ", allocationSize = 1)
public class Transaction {

	@Id
	@GeneratedValue(generator = "TRANSACTION_GENERATOR", strategy = GenerationType.SEQUENCE)
	@Column(name = "transaction_id")
	private Integer id;

	@Column(name = "value")
	private Double value;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	private TransactionType type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetime")
	private Calendar date;

	@Column(name = "description")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "account_id")
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", value=" + value + ", type=" + type + ", date=" + date + ", description="
				+ description + ", account=" + account + "]";
	}

}
