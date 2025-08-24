package com.example.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Admin;
import com.example.entity.User;

public interface AdminService {
	
	Admin createAdmin(int aId, String vin, String firstName, String lastName, String email,
			String password, long phoneNo, MultipartFile picture);
	
	Admin getAdminDetails(int aId);
	
	ResponseEntity<InputStreamResource> getAdminPicture(int aId);
	
	Admin getAdminByPhoneNo(long phoneNo);
	
	Admin updateAdmin(int aId, String vin, String firstName, String lastName, String email,
			String password, long phoneNo, MultipartFile picture);
	
	// to use patch type to only update password or photo or phone number
	
	String deleteAdmin(int aId);
	
	// USER
	
	User getUserDetails(int uId);
	
	User updateUser(int uId, String vin, String firstName, String lastName, String email,
			String password, long phoneNo, MultipartFile picture);
	
	List<User> showAllUser();
	
	String deleteUser(int uId);
	
	
	

}
