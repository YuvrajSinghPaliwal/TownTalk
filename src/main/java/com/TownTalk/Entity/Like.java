package com.TownTalk.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue
    private Long id;

    private Long likes;

    @ManyToOne
    @JsonIgnore
    private Post post;
    
    // Constructors
    
    public Like() {
		super();
	}

	public Like(Long id, Long likes, Post post) {
		super();
		this.id = id;
		this.likes=likes;
		this.post = post;
	}
    
    // getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser() {
		return likes;
	}

	public void setUser(Long likes) {
		this.likes=likes;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
    
    
}
