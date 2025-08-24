package com.example.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Admin;
import com.example.entity.User;
import com.example.repository.AdminRepository;
import com.example.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

	// creating new admin
	@Override
	public Admin createAdmin(int aId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) {
		
		byte[] pictureBytes = picture.getBytes();
		String encodedPassword = passwordEncoder.encode(password);
		Admin admin = new Admin(aId, vin, firstName, lastName, email, encodedPassword, phoneNo, pictureBytes);
		
		return adminRepository.save(admin);
	}

	// Returning admin details
	@Override
	public Admin getAdminDetails(int aId) {
		return adminRepository.findById(aId).get();
	}

	// Returning admin image
	@Override
	public ResponseEntity<InputStreamResource> getAdminPicture(int aId) {
		Admin admin = adminRepository.findById(aId).get();
		InputStreamResource pictureResource = new InputStreamResource(new ByteArrayInputStream(admin.getPicture()));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureResource);
	}

	/. 
	@Override
	public Admin getAdminByPhoneNo(long phoneNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin updateAdmin(int aId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAdmin(int aId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserDetails(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(int uId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> showAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

}
