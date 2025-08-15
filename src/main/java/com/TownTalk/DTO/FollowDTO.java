package com.TownTalk.DTO;

public class FollowDTO {
	
    private Long followerId; 
    private String townId;
	public Long getFollowerId() {
		return followerId;
	}
	public void setFollowerId(Long followerId) {
		this.followerId = followerId;
	}
	public String getTownId() {
		return townId;
	}
	public void setTownId(String townId) {
		this.townId = townId;
	}
	public FollowDTO(Long followerId, String townId) {
		super();
		this.followerId = followerId;
		this.townId = townId;
	}
	public FollowDTO() {
		super();
	} 
    
    
}
