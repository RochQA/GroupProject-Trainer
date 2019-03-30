package com.qa.trainer.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.trainer.service.TrainerServiceImpl;

@RestController
public class TrainerController {
	
	TrainerServiceImpl srvc;

	@PutMapping("/getDisplayName")
	public String getDisplayName(@RequestBody String fullName) {
		return srvc.getDisplayName(fullName);
	}
}
