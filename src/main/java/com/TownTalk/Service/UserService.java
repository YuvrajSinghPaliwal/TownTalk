package com.TownTalk.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TownTalk.Entity.Users;
import com.TownTalk.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
   
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public Users save(Users user) {
        
    	user.setPassword(encoder.encode(user.getPassword()));
    	
    	
        return userRepository.save(user);
    }

    public Users update(Users user) {
        if (!userRepository.existsById(user.getId())) {
            throw new RuntimeException("User not found with id " + user.getId());
        }
        else{
        	user.setPassword(encoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }
}

