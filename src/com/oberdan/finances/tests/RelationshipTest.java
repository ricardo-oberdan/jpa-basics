package com.oberdan.finances.tests;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.oberdan.finances.enums.TransactionType;
import com.oberdan.finances.model.Account;
import com.oberdan.finances.model.Transaction;
import com.oberdan.finances.util.JPAUtil;

public class RelationshipTest {
	public static void main(String[] args) {
		Double value = new Double(100.56);
		
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		Account conta = em.find(Account.class, 169878);
		
		Transaction mov = new Transaction();
		mov.setAccount(conta);
		mov.setDescription("Credit Card Bill");
		mov.setType(TransactionType.DEBIT);
		mov.setValue(value);
		mov.setDate(Calendar.getInstance());
		
		em.persist(mov);
		
		conta.setBalance(conta.getBalance() - value);

		System.out.println(mov);
		System.out.println(conta);
		
		em.getTransaction().commit();

		em.close();
	}
}
