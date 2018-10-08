package com.oberdan.finances.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.oberdan.finances.model.Account;
import com.oberdan.finances.util.JPAUtil;

public class AllTransactionsWithJPQL {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		String jpql = "select distinct a from Account a left join fetch a.transactions order by a.id";
		
		Query query = em.createQuery(jpql);
		List<Account> accounts = query.getResultList();
		for (Account account : accounts) {
			System.out.println(account.getId() + "-" + account.getHolder());
			System.out.println("-> Transactions");
			System.out.println(account.getTransactions());
			System.out.println("--------------");			
			System.out.println("");			
		}
		
		em.close();
		JPAUtil.closeEntityManager();
	}
	
}
