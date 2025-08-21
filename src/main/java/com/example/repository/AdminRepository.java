package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, Integer>{
	Admin findByPhoneNo(long phoneNo);

}
