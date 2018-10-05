package com.oberdan.finances.tests;

import javax.persistence.EntityManager;

import com.oberdan.finances.model.Account;
import com.oberdan.finances.util.JPAUtil;

public class AccountUpdateTest {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityManager em2 = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		// -> account will be managed
		Account conta = em.find(Account.class, 123456);
		System.out.println(conta);

		// -> account is managed, so we can change attribute values
		// when use this object, will be generated a update statement
		conta.setHolder("New Holder");
		System.out.println(conta);

		em.getTransaction().commit();
		em.close();

		// -> At this point account is Detached, why we close entity manager
		em2.getTransaction().begin();
		conta.setBalance(0.99);
		// em2.persist(conta); // PersistentObjectException: detached entity passed to
		// persist
		// To prevent, use merge
		em2.merge(conta);

		em2.getTransaction().commit();

		//Removing account from database
		em2.getTransaction().begin();
		conta = em2.find(Account.class, 867591);
		em2.remove(conta);

		em2.getTransaction().commit();

		em2.close();
		JPAUtil.closeEntityManager();
	}

}
