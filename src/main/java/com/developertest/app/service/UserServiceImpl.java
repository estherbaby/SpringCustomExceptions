package com.developertest.app.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developertest.app.ui.request.model.UserDetails;
import com.developertest.app.ui.response.model.User;
import com.developertest.app.shared.Util;

@Service
public class UserServiceImpl implements UserService{
	/*
	 * @Autowired Util util;
	 * 
	 * converting above into dependency injection based on construtor
	 */
	Util util;
	public UserServiceImpl() {};
	
	@Autowired
	public UserServiceImpl(Util util) {
		this.util = util;
	};
	/* Ended dependency injection based on construtor*/

	@Override
	public User createUser(UserDetails userDetails) {
		User user = new User();
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		
		String uid = util.genrateId();
		user.setUserId(uid);
		return user;
	}

}
