package com.developertest.app.ui.request.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserDetails {
	@NotNull(message = "firstName cannot be null")
	@Size(min=2, message = "The firstName should contain aleast 2 characters")
	private String firstName;
	
	@NotNull(message = "firstName cannot be null")
	@Size(min=2, message = "The firstName should contain aleast 2 characters")
	private String lastName;
	
	@NotNull
	@Email(message = "Not valid email format")
	private String email;
	
	@NotNull(message ="Password should be non null")
	@Size(min=2,max=8, message="The password should contain aleast 2 characters and a maximum of 8 characters")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
