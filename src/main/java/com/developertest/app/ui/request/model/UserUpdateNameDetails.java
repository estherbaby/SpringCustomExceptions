package com.developertest.app.ui.request.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserUpdateNameDetails {
	
	@NotNull(message = "firstName cannot be null")
	@Size(min=2, message = "The firstName should contain aleast 2 characters")
	private String firstName;
	
	@NotNull(message = "firstName cannot be null")
	@Size(min=2, message = "The firstName should contain aleast 2 characters")
	private String lastName;

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
