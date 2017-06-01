package com.xpo.bean;

import javax.validation.constraints.NotNull;

public class UserBean {
	
	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	private String type;
	

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
