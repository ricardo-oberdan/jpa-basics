package com.oberdan.finances.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.oberdan.finances.model.Transaction;
import com.oberdan.finances.util.JPAUtil;

public class TransactionSearchWithJPQL {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		
		String jpql = "select t from Transaction t where t.account.id = :acc";
		Query query = em.createQuery(jpql);
		query.setParameter("acc", 169878);
		
		List<Transaction> list = query.getResultList();
		for (Transaction transaction : list) {
			System.out.println(transaction);
		}
		
		em.close();
		JPAUtil.closeEntityManager();
	}

}
