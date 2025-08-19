package com.TownTalk.DTO;

public class LoginDTO {
	
	private String uEmail;
	private String password;
	public String getUEmail() {
		return uEmail;
	}
	public void setUEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDTO(String uEmail, String password) {
		super();
		this.uEmail = uEmail;
		this.password = password;
	}
	public LoginDTO() {
		super();
	}
	
	
	
}
