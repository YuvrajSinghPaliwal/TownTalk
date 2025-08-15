package com.TownTalk.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.TownTalk.Entity.Media;
import com.TownTalk.Repository.MediaRepository;



@Service
public class MediaService {
	

	@Autowired
	private MediaRepository repo;
	
	public Media save(MultipartFile m) throws IOException {
		Media media=new Media();
		media.setType(m.getContentType());
		media.setFileName(m.getOriginalFilename());
		media.setFileData(m.getBytes());
		
		return repo.save(media);
	}

	public List<Media> get() {
		
		return repo.findAll();
	}
}
