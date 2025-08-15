
package com.TownTalk.Service;

import com.TownTalk.DTO.PostDTO;

import com.TownTalk.Entity.Media;
import com.TownTalk.Entity.Post;
import com.TownTalk.Entity.Town;
import com.TownTalk.Repository.MediaRepository;
import com.TownTalk.Repository.PostRepository;
import com.TownTalk.Repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TownRepository townRepository;
    
    @Autowired
    private MediaRepository mediaRepository; // Inject the new repository

    public Optional<Post> getPostById(Long postId) {
        return postRepository.findById(postId);
    }

 

 // You can also create a method to save a new Post with media
    public Post createPostWithMedia(PostDTO postDTO, MultipartFile media) throws IOException {
        
        
       
        Town town = townRepository.findTownById(postDTO.getTownId());   

        Post post = new Post();
        post.setCaption(postDTO.getCaption());
        // Then, set the post reference in each media file and save them
        Media m=new Media();
       
            
           if(media!=null) {
        	   m.setFileName(media.getOriginalFilename());
               m.setType(media.getContentType());
               m.setFileData(media.getBytes());
               mediaRepository.save(m);
           }
            
        
        post.setMedia(m);
        post.setTown(town);
        
        post.setCreatedAt(LocalDateTime.now());

        return postRepository.save(post);
        
    }

//    public Post createPost(PostDTO request) {
//     
//        Town town = townRepository.findTownById(request.getTownId());   
//
//        Post post = new Post();
//        post.setCaption(request.getCaption());
//        post.setImageUrl(request.getImageUrl());
//        post.setTown(town);
//        
//        post.setCreatedAt(LocalDateTime.now());
//
//        return postRepository.save(post);
//    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }
}