package com.example.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Admin;
import com.example.entity.User;

@Service
public class AdminServiceImpl implements AdminService{

	@Override
	public Admin createAdmin(int aId, String vin, String firstName, String lastName, String email, String password,
			long phoneNo, MultipartFile picture) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin getAdminDetails(int aId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<InputStreamResource> getAdminPic(int aId) {
		// TODO Auto-generated method stub
		return null;
	}

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
