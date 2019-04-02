package com.qa.trainer.controller;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;
import com.qa.trainer.entities.Constants;
import com.qa.trainer.entities.CreateAccount;
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.entities.UpdateAccount;
import com.qa.trainer.service.TrainerServiceImpl;

@RestController
public class TrainerController {
	
	TrainerServiceImpl srvc;

	private RestTemplateBuilder rest;
	private EurekaClient client;
	
	public TrainerController(TrainerServiceImpl srvc, RestTemplateBuilder rest, EurekaClient client) {
		this.srvc = srvc;
		this.rest = rest;
		this.client = client;
	}
	
	@PutMapping("/checkValid")
	public String checkTrainer(@RequestBody CreateAccount createAccount) {
		return srvc.checkTrainer(createAccount, getAllTrainers());
	}
	@PutMapping("/checkUpdateValid")
	public String checkUpdateValid(@RequestBody UpdateAccount account) {
		return srvc.checkUpdateAccount(account, getTrainer(account.getTrainerId()), getAllTrainers());	
	}
	private List<Trainer> getAllTrainers(){
		return this.rest.build().exchange(client.getNextServerFromEureka(Constants.GATEWAY, false).getHomePageUrl()+Constants.GET_TRAINERS_PATH, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Trainer>>(){}).getBody();
	}
	private Trainer getTrainer(Long trainerId) {
		HttpEntity<Long> entity = new HttpEntity<>(trainerId);
		return this.rest.build().exchange(client.getNextServerFromEureka(Constants.GATEWAY, false).getHomePageUrl()+Constants.GET_TRAINER_PATH, 
				HttpMethod.PUT, entity, Trainer.class).getBody();
	}
}
