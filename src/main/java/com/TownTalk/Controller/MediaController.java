package com.TownTalk.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.TownTalk.Entity.Media;
import com.TownTalk.Service.MediaService;



@RestController
public class MediaController {

	@Autowired
	private MediaService service;
	
	@GetMapping("/getMedia")
	public List<Media> get() {
		return service.get();		
	}
	
	@PostMapping("saveMedia")
	    public ResponseEntity<Media> save(MultipartFile m ) {
	        
	        try {
				return new ResponseEntity<>(service.save(m), HttpStatus.CREATED);
			} catch (IOException e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
				
			}
     }
}

