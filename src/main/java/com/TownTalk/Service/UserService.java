package com.TownTalk.Service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TownTalk.DTO.LoginDTO;
import com.TownTalk.DTO.RegisterDTO;
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

    public Users save(RegisterDTO user) {
        
    	Users users=new Users();
    
    	users.setUsername(user.getUsername());
    	users.setUEmail(user.getUEmail());
    	users.setUContact(user.getUContact());
    	users.setPassword(encoder.encode(user.getPassword()));
    	
    	
        return userRepository.save(users);
    }
    
    public Users authenticate(String email, String rawPassword) {
        return userRepository.findByuEmail(email)
               .filter(users -> encoder.matches(rawPassword, users.getPassword()))
               .orElse(null);
    }

    public Users update(Users user) {
        if (!userRepository.existsById(user.getUId())) {
            throw new RuntimeException("User not found with id " + user.getUId());
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

