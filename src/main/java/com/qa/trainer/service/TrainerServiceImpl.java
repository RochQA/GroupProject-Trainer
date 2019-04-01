package com.qa.trainer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.trainer.entities.Account;
import com.qa.trainer.entities.Constants;
import com.qa.trainer.entities.CreateAccount;
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.entities.UpdateAccount;

@Service
public class TrainerServiceImpl {

//	@Override
	public String getDisplayName(String fullName) {
		String[] splitName = fullName.split("/");
		String firstName= splitName[0];
		return firstName.substring(0, 1)+" "+splitName[1];
	}
	
	public String checkDuplicates(CreateAccount accountC, List<Trainer> trainers) {
		Trainer matchingTrains = new Trainer();
		matchingTrains = trainers.stream()
				.filter(trainer -> accountC.getTrainerFirstName().equals(trainer.getFirstName()) && accountC.getTrainerLastName().equals(trainer.getLastName()))
				.findFirst()
				.orElse(new Trainer());
		if (matchingTrains.getFirstName() != null) {
			return Constants.TRAINER_EXISTS_MESSAGE;
		}else return Constants.VALID_MESSAGE;
	}
	
	public String checkUpdateAccount(UpdateAccount account, Trainer oldTrainer, List<Trainer> accounts) {
				Trainer matchingAccs = accounts.stream()
						.filter(acc -> oldTrainer.getId().equals(acc.getId()))
						.findFirst()
						.orElse(new Trainer());
				accounts.remove(matchingAccs);
				return checkDuplicates(account, accounts);				
	}
	public Boolean isFirstNameValid(String firstName) {
		return  (!firstName.equals(firstName.toLowerCase()) && !firstName.equals(firstName.toUpperCase()) 
				&& firstName.length() >= 2 && firstName.matches(Constants.PASSCHARS));
	}
	public Boolean isLastNameValid(String lastName) {
		return  (!lastName.equals(lastName.toLowerCase()) && !lastName.equals(lastName.toUpperCase()) 
				&& lastName.length() >= 2 && lastName.matches(Constants.PASSCHARS));
	}

	public String checkTrainer(CreateAccount createAccount, List<Trainer> trainers) {
		if(isFirstNameValid(createAccount.getTrainerFirstName()) && isLastNameValid(createAccount.getTrainerLastName())) {
			return checkDuplicates(createAccount, trainers);
		}
		return Constants.NAMES_INVALID;
	}


}

// firstname, lastname, displayname, 