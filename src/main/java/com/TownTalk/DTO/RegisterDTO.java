package com.TownTalk.DTO;

public class RegisterDTO {
	
	private String uEmail;
    private Long uContact;
    private String username;
    private String password;
      
    
	public RegisterDTO() {
		super();
	}
	
	public RegisterDTO(String uEmail, Long uContact, String username, String password) {
		super();
		this.uEmail = uEmail;
		this.uContact = uContact;
		this.username = username;
		this.password = password;
	}
	
	public String getUEmail() {
		return uEmail;
	}
	public void setUEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public Long getUContact() {
		return uContact;
	}
	public void setUContact(Long uContact) {
		this.uContact = uContact;
	}
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
    
    
}
