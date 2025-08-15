package com.TownTalk.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TownTalk.Entity.User;
import com.TownTalk.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public User save(User user) {
        // Add any business rules/validations here
        return userRepository.save(user);
    }

    public User update(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new RuntimeException("User not found with id " + user.getId());
        }
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}

