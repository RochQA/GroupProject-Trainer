package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.trainer.TrainerApplication;
import com.qa.trainer.entities.Constants;
import com.qa.trainer.entities.CreateAccount;
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.entities.UpdateAccount;
import com.qa.trainer.service.TrainerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = TrainerApplication.class)
public class TrainerServiceTests {
	
	Trainer jordan;
	Trainer chester;
	List<Trainer> trainers;
	CreateAccount accountC;
	@InjectMocks
	TrainerServiceImpl svc;
	UpdateAccount upAccount;

	@Before
	public void setup() {
		jordan = new Trainer();
		chester = new Trainer();
		accountC = new CreateAccount();
		upAccount = new UpdateAccount();
		
		jordan.setFirstName("Jordan");
		jordan.setLastName("Harrison");
		jordan.setId(1L);
		
		chester.setFirstName("Chester");
		chester.setLastName("Gardner");
		chester.setId(2L);
		
		accountC.setTrainerFirstName("Naomi");
		accountC.setTrainerLastName("Stanley");
		
		trainers = new ArrayList<Trainer>();
		
		trainers.add(jordan);
		trainers.add(chester);
		
		upAccount.setTrainerFirstName("Jordan");
		upAccount.setTrainerLastName("Harrison");
	}

	@Test
	public void testGetDisplayName() {
		assertEquals(svc.getDisplayName("John/Brown"), "J Brown");
	}

	@Test
	public void testCheckDuplicates() {
		assertEquals(svc.checkDuplicates(accountC, trainers), Constants.VALID_MESSAGE);
	}

	@Test
	public void testCheckDuplicates2() {
		accountC.setTrainerFirstName("Jordan");
		accountC.setTrainerLastName("Harrison");
		assertEquals(svc.checkDuplicates(accountC, trainers), Constants.TRAINER_EXISTS_MESSAGE);
	}

	@Test
	public void testCheckUpdateAccount() {
		assertEquals(svc.checkUpdateAccount(upAccount, jordan, trainers), Constants.VALID_MESSAGE );
	}
	
	@Test
	public void testFirstNameValid() {
		assertEquals(svc.isFirstNameValid("John"), true);
	}

	@Test
	public void testFirstNameInvalid() {
		assertEquals(svc.isFirstNameValid("J0hn"), false);
	}

	@Test
	public void testLastNameValid() {
		assertEquals(svc.isFirstNameValid("Brown"), true);
	}

	@Test
	public void testLastNameInvalid() {
		assertEquals(svc.isFirstNameValid("Br0wn"), false);
	}

	@Test
	public void testCheckTrainer() {
		assertEquals(svc.checkTrainer(accountC, trainers), Constants.VALID_MESSAGE);
	}

	@Test
	public void testCheckTrainer2() {
		accountC.setTrainerFirstName("Na0mi");
		assertEquals(svc.checkTrainer(accountC, trainers), Constants.NAMES_INVALID);
	}
}