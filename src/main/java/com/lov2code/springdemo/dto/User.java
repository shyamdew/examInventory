package com.lov2code.springdemo.dto;

public class User {
	private String username;
	private String password;
	private String submit;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", submit=" + submit + "]";
	}
	
}
