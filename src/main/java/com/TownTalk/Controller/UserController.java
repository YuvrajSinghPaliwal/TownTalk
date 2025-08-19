package com.TownTalk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TownTalk.DTO.LoginDTO;
import com.TownTalk.DTO.RegisterDTO;
import com.TownTalk.Entity.Users;
import com.TownTalk.Service.JwtService;
import com.TownTalk.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;
    
    @GetMapping()
    public List<Users> getUser() {
        return userService.findAll();
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO user) {
    	
    	//we are giving email but it is still authenticating using spring security internal using username and password
    	//so we need to deepdive in spring security filter for better control
    	Authentication auth=authenticationManager
    			.authenticate(new UsernamePasswordAuthenticationToken(user.getUEmail(),user.getPassword()));
    	
    	if(auth.isAuthenticated()) {
    		String token =jwtService.generateToken(user.getUEmail());
    		return new ResponseEntity<>(token,HttpStatus.OK);
    	}
    	else {
    		return new ResponseEntity<>("Failed autherization",HttpStatus.UNAUTHORIZED);
    	}
    	
    	
//    	Users users = userService.authenticate(user.getUEmail(), user.getPassword());
//        if (users == null) {
//            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
//        }
//        // generate token or session here if applicable
//        return ResponseEntity.ok(users);
    }
    

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/register")
    public Users createUser(@RequestBody RegisterDTO user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public Users updateUser(@RequestBody Users user) {
        
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
