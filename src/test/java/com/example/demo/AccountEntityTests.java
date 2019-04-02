package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.trainer.TrainerApplication;
import com.qa.trainer.entities.Account;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = TrainerApplication.class)
public class AccountEntityTests {

	@InjectMocks
	Account acc;
	
	@Test
	public void setUpAccount() {
		acc.setId(5L);
		acc.setEmail("chris@chris.chris");
		acc.setPassword("password");
		acc.setTrainerId(1345L);
		
		
		assertEquals(acc.getId(),(Long) 5L);
		assertEquals(acc.getPassword(),"password");
		assertEquals(acc.getEmail(),"chris@chris.chris");
		assertEquals(acc.getTrainerId(),(Long)1345L);
	}
	
}
