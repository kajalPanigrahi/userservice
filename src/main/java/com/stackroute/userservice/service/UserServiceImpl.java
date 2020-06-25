package com.stackroute.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.Order;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) throws UserAlreadyExistsException {
	
		Optional<User> userExists = userRepository.findById(user.getId());
		if(userExists.isPresent()) {
			throw new UserAlreadyExistsException();
		}
		else {
			return userRepository.save(user);
		}
		}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String id) throws UserNotFoundException {
		Optional<User> userExists = userRepository.findById(id);
		if(userExists.isPresent()) {
			return userExists.get();
		}
		else {
			throw new UserNotFoundException();
		}
		
	}

	@Override
	public Object deleteUser(String id) throws UserNotFoundException {
		
		Optional<User> userExists = userRepository.findById(id);
		if(userExists.isPresent()) {
			userRepository.delete(userExists.get());
			return null;
		}
		else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public User updateUser(User user) throws UserNotFoundException {
		
		Optional<User> userExists = userRepository.findById(user.getId());
		if(userExists.isPresent()) {
			return userRepository.save(user);
			 
		}
		else {
			throw new UserNotFoundException();
		}
	}

	@Override
	public List<Order> getUserOrders(String id) throws UserNotFoundException {
		List<Order> userOrders = null;
		
			Optional<User> userExists = userRepository.findById(id);
			if(userExists.isPresent()) {
				userOrders =  userExists.get().getOrderHistory();
			}
			else {
				throw new UserNotFoundException();
			}
		return  userOrders;
		
	}

}
