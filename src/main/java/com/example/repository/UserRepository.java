package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{
	Optional<User> findByPhoneNo(long phoneNo);

}
