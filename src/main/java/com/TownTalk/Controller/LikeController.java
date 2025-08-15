package com.TownTalk.Controller;

import com.TownTalk.Entity.Like;
import com.TownTalk.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("/post/{postId}/user/{userId}")
    public ResponseEntity<Like> createLike(@PathVariable Long postId) {
        Like newLike = likeService.createLike(postId);
        return new ResponseEntity<>(newLike, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Like> getAllLikes() {
        return likeService.findAll();
    }
}