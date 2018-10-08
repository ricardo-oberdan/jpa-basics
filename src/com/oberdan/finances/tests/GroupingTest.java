package com.oberdan.finances.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.oberdan.finances.enums.TransactionType;
import com.oberdan.finances.util.JPAUtil;

public class GroupingTest {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		String jpql = "select trunc(t.date), sum(t.value) from Transaction t where type=:pType group by trunc(t.date)";

		Query query = em.createQuery(jpql);
		query.setParameter("pType", TransactionType.DEBIT);
		List<Double> result = query.getResultList();

		em.close();
		JPAUtil.closeEntityManager();


	}

}
