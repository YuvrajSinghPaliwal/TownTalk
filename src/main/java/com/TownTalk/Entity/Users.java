package com.TownTalk.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Users {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uId; // Auto-increment primary key

    @Column(unique = true, nullable = false)
    private String uEmail; // Unique for authentication
    
    private Long uContact;
    private String username;
    private String password;
    
	public Users() {
		super();
	}

	public Long getUId() {
		return uId;
	}

	public void setUId(Long uId) {
		this.uId = uId;
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



	public Users(Long uId, String uEmail, Long uContact, String username, String password) {
		super();
		this.uId = uId;
		this.uEmail = uEmail;
		this.uContact = uContact;
		this.username = username;
		this.password = password;
	}

	
    
}

	
	

