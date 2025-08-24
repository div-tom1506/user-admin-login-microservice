package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestParam int uId, @RequestParam String vin, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam long phoneNo, @RequestBody MultipartFile picture) {
		return userService.createUser(uId, vin, firstName, lastName, email, password, phoneNo, picture);
	}
	
	@GetMapping("/picture/{id}")
	public ResponseEntity<InputStreamResource> getUserPicture(@PathVariable("id") int uId) {
		return userService.getUserPicture(uId);
	}
	
	

}
