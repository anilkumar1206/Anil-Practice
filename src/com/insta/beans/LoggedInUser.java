package com.insta.beans;

public class LoggedInUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6528038997001441599L;
	private String email;
	private String firstname;
	private String lastname;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public LoggedInUser(String email, String firstname, String lastname) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	
	
	

}
