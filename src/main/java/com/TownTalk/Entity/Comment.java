package com.TownTalk.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private LocalDateTime createdAt;


    @ManyToOne
    @JsonIgnore
    private Post post;

    // Constructors
    
    public Comment(Long id, String content, LocalDateTime createdAt, Post post) {
		super();
		this.id = id;
		this.content = content;
		this.createdAt = createdAt;
		this.post = post;
	}

	public Comment() {
		super();
	}
    
    // getters and setters 
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

    
}
