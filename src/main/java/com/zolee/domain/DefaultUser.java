package com.zolee.domain;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class DefaultUser {
	
	private String userName;
	private String userPassword;

	public DefaultUser() {
	}

	public DefaultUser(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public boolean equals(DefaultUser defaultUser) {
		if(userName.equals(defaultUser.getUserName())&&userPassword.equals(defaultUser.getUserPassword())) {
			return true;
		}
		return false;
	}
	
}
