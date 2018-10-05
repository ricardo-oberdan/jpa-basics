package com.oberdan.financas.tests;

import javax.persistence.EntityManager;

import com.oberdan.financas.model.Account;
import com.oberdan.financas.util.JPAUtil;

public class AccountSearchTest {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		Account conta = em.find(Account.class, 123456);
		System.out.println(conta);

		em.close();
		JPAUtil.closeEntityManager();
	}

}
