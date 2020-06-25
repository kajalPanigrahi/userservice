package com.stackroute.userservice.service;

import java.util.List;

import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.Order;
import com.stackroute.userservice.model.User;

public interface IUserService {
	
	public User saveUser(User user) throws UserAlreadyExistsException;
	public List<User> getAllUsers();
	public User getUserById(String id) throws UserNotFoundException;
	public Object deleteUser(String id) throws UserNotFoundException;
	public User updateUser(User user) throws UserNotFoundException;
	
	public List<Order> getUserOrders(String id) throws UserNotFoundException;
	

}
