package com.example.identityservice.dto;

import com.example.identityservice.entities.User;

public class UserDtoResponse {

	private long id;

	private String firstName;

	private String lastName;

	private String email;

	private String mobileNo;

	private String age;

	public UserDtoResponse(User user) {
		super();
		this.setId(user.getId());
		this.setFirstName(user.getFirstName());
		this.setLastName(user.getLastName());
		this.setEmail(user.getEmail());
		this.setMobileNo(user.getMobileNo());
		this.setAge(user.getAge());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
