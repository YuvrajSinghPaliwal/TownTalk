package com.TownTalk.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TownTalk.Entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    
    
    
    // Optionally to check if a user already liked a post
	boolean existsByPost_Id(Long postId);
}