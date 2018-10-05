package com.oberdan.financas.tests;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.oberdan.financas.enums.TransactionType;
import com.oberdan.financas.model.Account;
import com.oberdan.financas.model.Transaction;
import com.oberdan.financas.util.JPAUtil;

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
