package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, Integer>{
	Optional<Admin> findByPhoneNo(long phoneNo);

}
