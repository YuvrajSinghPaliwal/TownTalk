package com.TownTalk.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type; // e.g., "image", "video"
    private String fileName; // Optional: Store the original file name
    
    @Lob
    private byte[] fileData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public Media(Long id, String type, String fileName, byte[] fileData) {
		super();
		this.id = id;
		this.type = type;
		this.fileName = fileName;
		this.fileData = fileData;
	}
	public Media() {
		super();
	}
    
    
}
