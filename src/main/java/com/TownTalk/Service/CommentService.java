// CommentService.java
package com.TownTalk.Service;

import com.TownTalk.DTO.CommentDTO;

import com.TownTalk.Entity.Comment;
import com.TownTalk.Entity.Post;

import com.TownTalk.Repository.CommentRepository;
import com.TownTalk.Repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;
  
    public Comment createComment(CommentDTO request) {
        
        Post post = postRepository.getReferenceById(request.getPostId());
        

        Comment comment = new Comment();
        comment.setContent(request.getContent());
       
        comment.setPost(post);
       
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}
