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
import com.example.entity.Admin;
import com.example.entity.User;
import com.example.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PostMapping("/create")
	public Admin createAdmin(@RequestParam int aId, @RequestParam String vin, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam long phoneNo, @RequestBody MultipartFile picture) throws IOException {
		return adminService.createAdmin(aId, vin, firstName, lastName, email, password, phoneNo, picture);
	}
	
	@GetMapping("/{id}")
	public Admin getAdminDetails(@PathVariable("id") int aId) {
		return adminService.getAdminDetails(aId);
	}
	
	@GetMapping("/picture/{id}")
	public ResponseEntity<InputStreamResource> getUserPicture(@PathVariable("id") int aId) {
		return adminService.getAdminPicture(aId);
	}
	
	@GetMapping("/phone/{id}")
	public Admin getAdminByPhoneNo(@PathVariable("id") long aId) {
		return adminService.getAdminByPhoneNo(aId);
	}
	
	@PutMapping("/update")
	public Admin updateAdmin(@RequestParam int aId, @RequestParam String vin, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam long phoneNo, @RequestBody MultipartFile picture) throws IOException {
		return adminService.updateAdmin(aId, vin, firstName, lastName, email, password, phoneNo, picture);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAdmin(@PathVariable("id") int aId) {
		return adminService.deleteAdmin(aId);
	}
	
	// User
	
	@GetMapping("/user/{id}")
	public User getUserDetails(@PathVariable("id") int uId) {
		return adminService.getUserDetails(uId);
	}
	
	@PutMapping("/user/update")
	public User updateUser(@RequestParam int uId, @RequestParam String vin, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam long phoneNo, @RequestBody MultipartFile picture) throws IOException {
		return adminService.updateUser(uId, vin, firstName, lastName, email, password, phoneNo, picture);
	}
	
	@GetMapping("/user/all")
	public List<User> showAllUsers() {
		return adminService.showAllUsers();
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable("id") int uId) {
		return adminService.deleteUser(uId);
	}

}
