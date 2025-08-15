package com.TownTalk.Service;

import com.TownTalk.Entity.Like;
import com.TownTalk.Entity.Post;
import com.TownTalk.Repository.LikeRepository;
import com.TownTalk.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private PostRepository postRepository;
    

    public Like createLike(Long postId) {
       
        Post post = postRepository.getReferenceById(postId);
       
        Like like = new Like();
        like.setPost(post);
        

        return likeRepository.save(like);
    }

    public List<Like> findAll() {
        return likeRepository.findAll();
    }

    public Optional<Like> findById(Long id) {
        return likeRepository.findById(id);
    }
}
