package com.TownTalk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TownTalk.Entity.Media;



public interface MediaRepository extends JpaRepository<Media, Long> {
    
}
