package com.example.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.User;

public interface UserService {
	
	User createUser(int uId, String vin, String firstName, String lastName, String email, 
			String password, long phoneNo, MultipartFile picture);
	
	ResponseEntity<InputStreamResource> getUserPicture(int uId);
	
	User getUserDetails(int uId);
	
	User getByPhoneNo(long phoneNo);
	
	User updateUser(int uId, String vin, String firstName, String lastName, String email, 
			String password, long phoneNo, MultipartFile picture);
	
	// to use patch type to only update password or photo or phone number
	
	String deleteUser(int uId);
	
	List<User> showAllUsers();

}
