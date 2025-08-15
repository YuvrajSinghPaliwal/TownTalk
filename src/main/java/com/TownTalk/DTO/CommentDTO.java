package com.TownTalk.DTO;


public class CommentDTO {
    private String content;
   
    private Long postId;   // ID of the post
	public CommentDTO(String content, String townId, Long postId) {
		super();
		this.content = content;
	
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public CommentDTO() {
		super();
	}
 
    
    
}
