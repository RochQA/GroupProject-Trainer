package com.qa.trainer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.trainer.entities.Constants;
import com.qa.trainer.entities.CreateAccount;
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.entities.UpdateAccount;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	
	public String checkDuplicates(CreateAccount accountC, List<Trainer> trainers) {
		Trainer matchingTrainer = new Trainer();
		matchingTrainer = trainers.stream()
				.filter(trainer -> accountC.getTrainerFirstName().equals(trainer.getFirstName()) && accountC.getTrainerLastName().equals(trainer.getLastName()))
				.findFirst()
				.orElse(new Trainer());
		if (matchingTrainer.getFirstName() != null) {
			return Constants.TRAINER_EXISTS_MESSAGE;
		}else return Constants.VALID_MESSAGE;
	}
	@Override
	public String checkUpdateAccount(UpdateAccount account, Trainer oldTrainer, List<Trainer> accounts) {
			if(isFirstNameValid(account.getTrainerFirstName()) && isLastNameValid(account.getTrainerLastName())) {
				Trainer matchingAcc = accounts.stream()
						.filter(acc -> oldTrainer.getId().equals(acc.getId()))
						.findFirst()
						.orElse(new Trainer());
				accounts.remove(matchingAcc);
				return checkDuplicates(account, accounts);	
			}else return Constants.NAMES_INVALID;
	}
	public Boolean isFirstNameValid(String firstName) {
		return  (!firstName.equals(firstName.toLowerCase()) && !firstName.equals(firstName.toUpperCase()) 
				&& firstName.length() >= 2 && firstName.matches(Constants.PASSCHARS));
	}
	public Boolean isLastNameValid(String lastName) {
		return  (!lastName.equals(lastName.toLowerCase()) && !lastName.equals(lastName.toUpperCase()) 
				&& lastName.length() >= 2 && lastName.matches(Constants.PASSCHARS));
	}
	@Override
	public String checkTrainer(CreateAccount createAccount, List<Trainer> trainers) {
		if(isFirstNameValid(createAccount.getTrainerFirstName()) && isLastNameValid(createAccount.getTrainerLastName())) {
			return checkDuplicates(createAccount, trainers);
		}else return Constants.NAMES_INVALID;
			
	}


}