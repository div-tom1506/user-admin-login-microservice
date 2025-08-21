package com.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User createUser(int uId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<InputStreamResource> getUser(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserDetails(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByPhoneNo(long phoneNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(int uId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// to use patch type to only update password or photo or phone number

	@Override
	public String deleteUser(int uId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> showAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
