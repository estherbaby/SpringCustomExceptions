package com.developertest.app.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Util {
	
	
	
	public String genrateId() {
		return UUID.randomUUID().toString();
	}

}
