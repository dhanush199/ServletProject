package com.bridgelabz.configure.dbutil.model.servlet;

public class UserInfo {
	String phoneNumber;
	String email,password;
	String gender;
	String name;
	UserInfo user;
//	public UserInfo() {
//		this.phoneNumber = 0;
//		this.email = null;
//		this.name=null;
//		this.password = null;
//		this.gender = null;
//	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String usemail) {
		email = usemail;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}	
	public void setUserInfo(UserInfo users) {
		this.user=users;
	}
	public UserInfo getUserInfo() {
		return user;
		
	}
}
