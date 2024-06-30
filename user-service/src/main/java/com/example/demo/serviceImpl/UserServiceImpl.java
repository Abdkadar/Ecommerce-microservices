package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.User;
import com.example.demo.dto.CustomerClient;
import com.example.demo.dto.UserDTO;
import com.example.demo.feignclient.CustomerServiceClient;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo tenantRepository;
	
	@Autowired
	private CustomerServiceClient customerClient;
	
	

    @Override
    public User createUser(User user) {
        return tenantRepository.save(user);
    }

	@Override
	public UserDTO getUserById(Long userId) {
		CustomerClient client=customerClient.getCustomerById(userId);
		Optional<User> optionalUser = tenantRepository.findById(userId);
		UserDTO dto=UserMapper.MAPPER.toDto(optionalUser.get());
		dto.setCustomerClient(client);
		return dto;
	}

    @Override
    public List<User> getAllUsers() {
        return tenantRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = tenantRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = tenantRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        tenantRepository.deleteById(userId);
    }
}
