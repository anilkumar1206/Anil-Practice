package com.insta.beans;

import org.springframework.web.multipart.MultipartFile;

public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1050957644783064653L;

	private String username;
	private String password;
	private MultipartFile picture;
	private String email;
	private String phonenumber;
	private String firstname;
	private String lastname;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", picture=" + picture + ", email=" + email
				+ ", phonenumber=" + phonenumber + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
	
	
	
	
	
	
}
