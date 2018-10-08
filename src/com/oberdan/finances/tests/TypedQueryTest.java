package com.oberdan.finances.tests;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.oberdan.finances.util.JPAUtil;

public class TypedQueryTest {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		String jpql = "select avg(t.value) from Transaction t";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double result = query.getSingleResult();
		System.out.println(result);

		em.close();
		JPAUtil.closeEntityManager();

	}
}
