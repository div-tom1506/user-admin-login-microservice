package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestParam int uId, @RequestParam String vin, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam long phoneNo, @RequestBody MultipartFile picture) throws IOException {
		return userService.createUser(uId, vin, firstName, lastName, email, password, phoneNo, picture);
	}
	
	@GetMapping("/picture/{id}")
	public ResponseEntity<InputStreamResource> getUserPicture(@PathVariable("id") int uId) {
		return userService.getUserPicture(uId);
	}
	
	@GetMapping("/{id}")
	public User getUserDetails(@PathVariable("id") int uId) {
		return userService.getUserDetails(uId);
	}
	
	@GetMapping("/phone/{ph}")
	public User getByPhoneNo(@PathVariable("ph") int phoneNo) {
		return userService.getByPhoneNo(phoneNo);
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@RequestParam int uId, @RequestParam String vin, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam long phoneNo, @RequestBody MultipartFile picture) throws IOException {
		return userService.updateUser(uId, vin, firstName, lastName, email, password, phoneNo, picture);
	}
	
	@GetMapping("/all")
	public List<User> showAllUsers() {
		return userService.showAllUsers();
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") int uId) {
		return userService.deleteUser(uId);
	}
	
}
