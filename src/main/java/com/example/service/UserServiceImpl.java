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

import com.example.entity.User;
import com.example.exception.NotFoundException;
import com.example.exception.ValueAlreadyExistsException;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	//Creating new user
	@Override
	public User createUser(int uId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) throws IOException {
		
		if (userRepository.findByPhoneNo(phoneNo).isPresent()) {
			throw new ValueAlreadyExistsException("Phone number already exists");
		}
		
		byte[] pictureBytes = picture.getBytes();
		String encodedPassword = passwordEncoder.encode(password);
		User user = new User(uId, vin, firstName, lastName, email, encodedPassword,
				phoneNo, pictureBytes);
		
		return userRepository.save(user);
	}

	// Returning user image
	@Override
	public ResponseEntity<InputStreamResource> getUserPicture(int uId) {
		User user = userRepository.findById(uId)
				.orElseThrow(() -> new NotFoundException("User with ID " + uId + " not found"));
		InputStreamResource pictureResource = new InputStreamResource(new ByteArrayInputStream(user.getPicture()));
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureResource);
	}

	// Returning user details
	@Override
	public User getUserDetails(int uId) {
		return userRepository.findById(uId)
				.orElseThrow(() -> new NotFoundException("User with ID " + uId + " not found"));
	}

	// Returning user details with phone numbers
	@Override
	public User getByPhoneNo(long phoneNo) {
		User user = userRepository.findByPhoneNo(phoneNo)
				.orElseThrow(() -> new NotFoundException("User with phone number " + phoneNo + " not found"));
		return user;
	}

	// To update User details
	@Override
	public User updateUser(int uId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) throws IOException{
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
	
	// to use patch type to only update password or photo or phone number

	// To delete an user
	@Override
	public String deleteUser(int uId) {
		
		if (!userRepository.existsById(uId)) {
			throw new NotFoundException("User with ID " + uId + " not found");
		}

		userRepository.deleteById(uId);
		return "User Deleted Successfully";
	}

	// To get all users
	@Override
	public List<User> showAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}
}
