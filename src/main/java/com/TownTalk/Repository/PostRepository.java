package com.TownTalk.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.TownTalk.Entity.Post;

import jakarta.transaction.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
	    @Query(
	        value = "SELECT * FROM post p WHERE p.town_id = :townId", 
	        nativeQuery = true
	    )
	    List<Post> findAllPostsByTownId(@Param("townId") String townId);

	    // Native query with a more complex join
	    @Query(
	        value = "SELECT p.* FROM post p JOIN town t ON p.town_id = t.id WHERE t.name = :townName",
	        nativeQuery = true
	    )
	    List<Post> findAllPostsByTownName(@Param("townName") String townName);
	    
	    @Modifying
	    @Transactional
	    @Query(
	        value = "UPDATE post p SET p.caption = :newCaption WHERE p.id = :postId",
	        nativeQuery = true
	    )
	    int updatePostCaption(@Param("postId") Long postId, @Param("newCaption") String newCaption);
 
}
