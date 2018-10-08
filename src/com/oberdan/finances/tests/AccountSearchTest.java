package com.oberdan.finances.tests;

import javax.persistence.EntityManager;

import com.oberdan.finances.model.Account;
import com.oberdan.finances.model.Transaction;
import com.oberdan.finances.util.JPAUtil;

public class AccountSearchTest {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		Account conta = em.find(Account.class, 169878);
		System.out.println(conta.getId());
		for (Transaction transaction : conta.getTransactions()) {
			System.out.println(transaction.getDescription() + "-" + transaction.getType() + "-" + transaction.getValue());
		}

		em.close();
		JPAUtil.closeEntityManager();
	}

}
