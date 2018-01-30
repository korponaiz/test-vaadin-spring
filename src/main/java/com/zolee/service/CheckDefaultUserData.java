package com.zolee.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zolee.domain.DefaultUser;

@Service
public class CheckDefaultUserData {

	@Value("${com.test.name}")
	private String name;
	@Value("${com.test.password}")
	private String password;
	
	public boolean checkUser(DefaultUser tempUser) {
		if(tempUser.equals(new DefaultUser(name, password))) {
			return true;
		}
		return false;
	}
	
}
