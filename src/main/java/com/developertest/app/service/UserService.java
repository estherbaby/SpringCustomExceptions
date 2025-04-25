package com.developertest.app.service;

import com.developertest.app.ui.request.model.UserDetails;
import com.developertest.app.ui.response.model.User;


public interface UserService {
	
	public User createUser(UserDetails userDetails);

}
