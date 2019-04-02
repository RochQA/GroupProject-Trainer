package com.qa.trainer.service;

import java.util.List;

import com.qa.trainer.entities.CreateAccount;
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.entities.UpdateAccount;

public interface TrainerService {
	
	public String checkTrainer(CreateAccount createAccount, List<Trainer> trainers);
	
	public String checkUpdateAccount(UpdateAccount account, Trainer oldTrainer, List<Trainer> accounts); 
	
}
