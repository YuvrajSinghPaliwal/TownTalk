package com.TownTalk.DTO;

public class TownDTO {
    private String id;
	private String name;
	private int population;
	private String location;
	private String profilePicture;
    private String bio;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public TownDTO(String id, String name, int population, String location, String profilePicture, String bio) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.location = location;
		this.profilePicture = profilePicture;
		this.bio = bio;
	}
	public TownDTO() {
		super();
	}
    
    
	
    
}
