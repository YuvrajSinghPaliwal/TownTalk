package com.TownTalk.DTO;



public class PostDTO {
 private String caption;
 private String townId; // ID of the town
public String getCaption() {
	return caption;
}
public void setCaption(String caption) {
	this.caption = caption;
}

public String getTownId() {
	return townId;
}
public void setTownId(String townId) {
	this.townId = townId;
}
public PostDTO(String caption, String townId) {
	super();
	this.caption = caption;
	
	this.townId = townId;
}
public PostDTO() {
	super();
}
 
 
 
}