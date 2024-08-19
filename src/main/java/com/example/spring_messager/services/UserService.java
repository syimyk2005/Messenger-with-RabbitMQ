package com.example.spring_messager.services;
import com.example.spring_messager.repositoryes.UserRepository;
import com.example.spring_messager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username) {
        User user = new User();
        user.setUsername(username);
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
