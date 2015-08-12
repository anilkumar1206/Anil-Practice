package com.insta.service;

import com.insta.beans.LoggedInUser;
import com.insta.beans.User;
import com.insta.entities.InstaUserProfile;



public interface InstaService {
	
	public void saveNewUser(User user);
	
	public LoggedInUser getLoggedInUserDetailsByUserName(String username);
	
	public InstaUserProfile getUserProfile(String username);

}
