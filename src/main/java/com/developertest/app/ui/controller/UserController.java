package com.developertest.app.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developertest.app.exception.NullMapException;
import com.developertest.app.service.UserService;
import com.developertest.app.ui.request.model.UserDetails;
import com.developertest.app.ui.request.model.UserUpdateNameDetails;
import com.developertest.app.ui.response.model.User;

import jakarta.validation.Valid;


@RestController
@RequestMapping("users") // http://localhost:8080/users
@Validated
public class UserController {
	
	Map<String, User> userDb;
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "50") int limit) {
		if(userDb == null)
			throw new NullMapException("Map is null");
		return "Get users with page : " + page + " and limit : " + limit;
	}

	@GetMapping(path = "/{userId}", produces = { // MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> getUser(@PathVariable String userId) {
		if(userDb == null)
			throw new NullMapException("DB Map is null");

		if(userDb.containsKey(userId)) {
			return new ResponseEntity<>(userDb.get(userId), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = {			
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDetails userDetails) {
		
		User user = userService.createUser(userDetails);
		
		if(userDb==null) userDb=new HashMap<>();
		userDb.put(user.getUserId(), user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", produces = { // MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<User> updateUser(@PathVariable String userId, @Valid @RequestBody UserUpdateNameDetails userUpdateNameDetails) {
		User user = userDb.get(userId);
		user.setFirstName(userUpdateNameDetails.getFirstName());
		user.setLastName(userUpdateNameDetails.getLastName());
		userDb.put(userId, user);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@DeleteMapping(path ="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		userDb.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
