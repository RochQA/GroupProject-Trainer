package com.qa.trainer.service;

import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Override
	public String getDisplayName(String fullName) {
		String[] splitName = fullName.split("/");
		String firstName= splitName[0];
		return firstName.substring(0, 1)+" "+splitName[1];
	}

}
