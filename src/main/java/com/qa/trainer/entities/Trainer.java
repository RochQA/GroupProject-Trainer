package com.qa.trainer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainer {
	
	@Id
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

	public String getDisplayName() {
		return email;
	}

	public void setDisplayName(String displayName) {
		this.email = displayName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


}
