package com.TownTalk.Controller;

import com.TownTalk.DTO.PostDTO;


import com.TownTalk.Entity.Post;
import com.TownTalk.Service.PostService;

import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    
    
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Post> createPost(
        @Parameter(description = "Post data", required = true)
        @RequestPart("request") PostDTO request,

        @Parameter(description = "Media file to upload", required = true)
        @RequestPart("mediaList") MultipartFile mediaList) {
        
        try {
			return new ResponseEntity<>(postService.createPostWithMedia(request, mediaList), HttpStatus.CREATED);
		} catch (IOException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
    }

    @GetMapping
    public List<Post> getAllPosts() {
    	
        return postService.findAll();
        
        
    }

  
    

    // Existing endpoint to get a single post
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Optional<Post> post = postService.getPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

   
}