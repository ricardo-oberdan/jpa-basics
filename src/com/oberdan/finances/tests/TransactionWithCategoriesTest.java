package com.oberdan.finances.tests;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.oberdan.finances.enums.TransactionType;
import com.oberdan.finances.model.Account;
import com.oberdan.finances.model.Category;
import com.oberdan.finances.model.Transaction;
import com.oberdan.finances.util.JPAUtil;

public class TransactionWithCategoriesTest {
	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();
		Account acc = new Account();
		acc.setId(169878);
		
		List<Category> categories = Arrays.asList(new Category(3), new Category(5));
		
		Transaction mov = new Transaction();
		mov.setAccount(acc);
		mov.setDescription("Dinner and Fun");
		mov.setType(TransactionType.DEBIT);
		mov.setValue(88.01);
		mov.setDate(Calendar.getInstance());
		mov.setCategories(categories);		
		
		em.persist(mov);
	
		em.getTransaction().commit();

		em.close();
		JPAUtil.closeEntityManager();
	}
}
