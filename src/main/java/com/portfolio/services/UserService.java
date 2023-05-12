package com.portfolio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.entities.User;
import com.portfolio.exceptions.ResourceNotFoundException;

@Service
public interface UserService {
	
    User createUser(User user);

    User getUserById(Long userId) throws ResourceNotFoundException;

    List<User> getAllUsers();

    User updateUser(User user) throws ResourceNotFoundException;

    void deleteUser(Long userId) throws ResourceNotFoundException;
}
