package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "ADMIN_INFO")
public class Admin {
	
	@Id
	private int aId;
	private String vin;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long phoneNo;
	private byte[] picture;

}
