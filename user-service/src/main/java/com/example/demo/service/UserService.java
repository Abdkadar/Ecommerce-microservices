package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.bean.User;
import com.example.demo.dto.UserDTO;

@Component
public interface UserService {

	User createUser(User user);

	UserDTO getUserById(Long userId);

	List<User> getAllUsers();

	User updateUser(User user);

	void deleteUser(Long userId);

}
