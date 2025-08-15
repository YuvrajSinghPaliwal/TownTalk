package com.TownTalk.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Town {

	@Id 
	@Column(name="town_id")
	private String townId;
	private String name;
	private int population;
	private String location;
	private String profilePicture;
    private String bio;
	
	@OneToMany(mappedBy = "town", cascade = CascadeType.ALL)
    private List<Post> posts;

	// constructors
	
	public Town(String townId, String name, int population, String location, String profilePicture, String bio,
			List<Post> posts) {
		super();
		this.townId = townId;
		this.name = name;
		this.population = population;
		this.location = location;
		this.profilePicture = profilePicture;
		this.bio = bio;
		this.posts = posts;
	}

	public Town() {
		super();
	}

	// getters and setters
	
	public String getId() {
		return townId;
	}

	public void setId(String townId) {
		this.townId = townId;
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

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
