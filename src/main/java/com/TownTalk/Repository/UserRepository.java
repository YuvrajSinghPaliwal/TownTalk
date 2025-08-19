package com.TownTalk.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TownTalk.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    
    Optional<Users> findByUsername(String username);
    
    boolean existsByUsername(String username);

	Optional<Users> findByuEmail(String uEmail);
}
