package com.oberdan.finances.tests;

import javax.persistence.EntityManager;

import com.oberdan.finances.model.Account;
import com.oberdan.finances.util.JPAUtil;

public class PopulateAccounts {

	public static void main(String[] args) {

		EntityManager manager = JPAUtil.getEntityManager();

		manager.getTransaction().begin();

		Account conta1 = new Account();
		Account conta2 = new Account();
		Account conta3 = new Account();
		Account conta4 = new Account();
		Account conta5 = new Account();

		conta1.setId(169878);
		conta1.setBank(001);
		conta1.setAgency(6543);
		conta1.setHolder("Maria dos Santos");
		conta1.setBalance(1000.00);
		
		conta2.setId(867591);
		conta2.setBank(237);
		conta2.setAgency(1745);
		conta2.setHolder("Paulo Roberto Souza");
		conta2.setBalance(0.0);

		conta3.setId(463463);
		conta3.setBank(341);
		conta3.setAgency(4606);
		conta3.setHolder("Antonio Duraes");
		conta3.setBalance(1000000.77);
		
		conta4.setId(123456);
		conta4.setBank(033);
		conta4.setAgency(9876);
		conta4.setHolder("Leandra Marques");
		conta4.setBalance(-100.99);
		
		conta5.setId(986543);
		conta5.setBank(104);
		conta5.setAgency(1234);
		conta5.setHolder("Alexandre Duarte");
		conta5.setBalance(-20000.00);

		// persistindo as contas
		manager.persist(conta1);
		manager.persist(conta2);
		manager.persist(conta3);
		manager.persist(conta4);
		manager.persist(conta5);

		manager.getTransaction().commit();

		manager.close();
		JPAUtil.closeEntityManager();

	}
}
