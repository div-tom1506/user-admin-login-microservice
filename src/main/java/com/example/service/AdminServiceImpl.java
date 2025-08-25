package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Admin;
import com.example.entity.User;
import com.example.exception.NotFoundException;
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

	// creating new admin
	@Override
	public Admin createAdmin(int aId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) throws IOException {
		
//		if (adminRepository.findByPhoneNo(phoneNo)) {
//		throw new ValueAlreadyExistsException("Phone number already exists");
//	}
		
		byte[] pictureBytes = picture.getBytes();
		String encodedPassword = passwordEncoder.encode(password);
		Admin admin = new Admin(aId, vin, firstName, lastName, email, encodedPassword, phoneNo, pictureBytes);
		
		return adminRepository.save(admin);
	}

	// Returning admin details
	@Override
	public Admin getAdminDetails(int aId) {
		return adminRepository.findById(aId)
				.orElseThrow(() -> new NotFoundException("Admin with ID " + aId + " not found"));
	}

	// Returning admin image
	@Override
	public ResponseEntity<InputStreamResource> getAdminPicture(int aId) {
		Admin admin = adminRepository.findById(aId)
				.orElseThrow(() -> new NotFoundException("Admin with ID " + aId + " not found"));
		InputStreamResource pictureResource = new InputStreamResource(new ByteArrayInputStream(admin.getPicture()));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureResource);
	}

	// 
	@Override
	public Admin getAdminByPhoneNo(long phoneNo) {
		Admin admin = adminRepository.findByPhoneNo(phoneNo);
		return admin;
	}

	@Override
	public Admin updateAdmin(int aId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) throws IOException {
		String encodedPassword = passwordEncoder.encode(password);
		Admin existingAdmin;
		
		if (picture == null) {
			Admin admin = adminRepository.findById(aId)
					.orElseThrow(() -> new NotFoundException("Admin with ID " + aId + " not found"));
			existingAdmin = new Admin(aId, vin, firstName, lastName, email, encodedPassword,
					phoneNo, admin.getPicture());
			adminRepository.save(existingAdmin);
		} else {
			byte[] pictureBytes = picture.getBytes();
			existingAdmin = new Admin(aId, vin, firstName, lastName, email, encodedPassword,
					phoneNo, pictureBytes);
		}
		
		return existingAdmin;
	}

	@Override
	public String deleteAdmin(int aId) {
		adminRepository.deleteById(aId);
		return "Admin Deleted Successfully";
	}

	@Override
	public User getUserDetails(int uId) {
		return userRepository.findById(uId)
				.orElseThrow(() -> new NotFoundException("User with ID " + uId + " not found"));
	}

	@Override
	public User updateUser(int uId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) throws IOException {
		String encodedPassword = passwordEncoder.encode(password);
		User existingUser;
		
		if (picture == null) {
			User user = userRepository.findById(uId)
					.orElseThrow(() -> new NotFoundException("User with ID " + uId + " not found"));
			existingUser = new User(uId, vin, firstName, lastName, email, encodedPassword,
					phoneNo, user.getPicture());
			userRepository.save(existingUser);
		} else {
			byte[] pictureBytes = picture.getBytes();
			existingUser = new User(uId, vin, firstName, lastName, email, encodedPassword,
					phoneNo, pictureBytes);
		}
		
		return existingUser;
	}

	@Override
	public List<User> showAllUser() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@Override
	public String deleteUser(int uId) {
		if (!userRepository.existsById(uId)) {
			throw new NotFoundException("User with ID " + uId + " not found");
		}
		
		userRepository.deleteById(uId);
		return "User Deleted Successfully";
	}

}
