package com.wipro.bank.assessment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wipro.bank.entity.Account;

public class AppTest {
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testGetAccountDetailsByID() {
		App.accounts.add(new Account (1,"acc1",101.11));		
		App.accounts.add(new Account (3,"acc3",303.33));
		App.accounts.add(new Account (4,"acc4",404.43));
		App.accounts.add(new Account (5,"acc5",505.55));	
		assertNull(new App().getAccountDetailsByID(567));		
		Account acc=new App().getAccountDetailsByID(3);
		assertNotNull(acc);
		assertEquals("acc3",acc.getUserName());
		assertNotEquals(App.accounts.get(2).getUserName(),acc.getUserName());
	}	
	
//	@Test
//	public void getAccountDetailsByBalance(){
//		App.accounts.add(new Account (1,"acc1",101.11));		
//		App.accounts.add(new Account (3,"acc3",303.33));
//		App.accounts.add(new Account (4,"acc4",404.43));
//		App.accounts.add(new Account (5,"acc5",505.55));	
//		assertNull("When No account found:",new App().getAccountDetailsByBalance(909.01));
//	}
	
	@Test
	public void testgetAccountDetailsByBalance(){
		App.accounts.add(new Account (1,"acc1",101.11));		
		App.accounts.add(new Account (3,"acc3",303.33));
		App.accounts.add(new Account (4,"acc4",404.43));
		App.accounts.add(new Account (5,"acc5",505.55));			
		assertNull("When No account found:",new App().getAccountDetailsByBalance(909.01));			
		List<Account> actualAccounts=new App().getAccountDetailsByBalance(101.11);
		assertNotNull(actualAccounts);
		assertEquals(App.accounts.size(),actualAccounts.size());		
		List<Account> actualAccounts1=new App().getAccountDetailsByBalance(500.00);		
		assertNotEquals(App.accounts.size(),actualAccounts1.size());		
	}
	
	/*
	
	@Test
	public void getAccountDetailsByBalance3(){
		App.accounts.add(new Account (1,"acc1",101.11));		
		App.accounts.add(new Account (3,"acc3",303.33));
		App.accounts.add(new Account (4,"acc4",404.43));
		App.accounts.add(new Account (5,"acc5",505.55));	
		double amount=201.01;
		
		List<Account> checkActualAccounts=new ArrayList<Account>();		
		for(Account account:App.accounts){			
			if(account.getBalance()>=amount){				
				checkActualAccounts.add(account);
			}
		}
		if(checkActualAccounts.size()==0){
			checkActualAccounts=null;
		}
		
		List<Account> actualAccounts=new App().getAccountDetailsByBalance(amount);
		assertNotNull(actualAccounts);
		assertEquals(checkActualAccounts.size(),actualAccounts.size());
	}*/

}
