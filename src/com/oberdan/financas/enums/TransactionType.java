package com.oberdan.financas.enums;

public enum TransactionType {
	CREDIT(0), DEBIT(1);

	private Integer id;

	private TransactionType(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
