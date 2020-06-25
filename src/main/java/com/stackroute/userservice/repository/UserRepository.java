package com.stackroute.userservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.userservice.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
