package com.qa.trainer.entities;

public class UpdateAccount extends CreateAccount{

	private String oldPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
