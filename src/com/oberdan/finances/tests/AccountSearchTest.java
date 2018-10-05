package com.oberdan.finances.tests;

import javax.persistence.EntityManager;

import com.oberdan.finances.model.Account;
import com.oberdan.finances.util.JPAUtil;

public class AccountSearchTest {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		Account conta = em.find(Account.class, 123456);
		System.out.println(conta);

		em.close();
		JPAUtil.closeEntityManager();
	}

}
