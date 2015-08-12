package com.insta.service;


import java.io.IOException;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;










import com.insta.beans.LoggedInUser;
import com.insta.beans.User;
import com.insta.dao.InstaDao;
import com.insta.entities.InstaUser;
import com.insta.entities.InstaUserProfile;
import com.insta.entities.InstaUserRole;
import com.insta.utils.SecurityUtils;

@Service
@Transactional
public class InstaServiceImp implements InstaService {
	@Autowired
	private InstaDao instaDao;

	@Override
	public void saveNewUser(User user) {
		// TODO Auto-generated method stub
		
		InstaUser iuser= new InstaUser();
		iuser.setEnabled(Boolean.TRUE);
		iuser.setUserCreatedDate(new Date());
		iuser.setUserUsername(user.getUsername());
		iuser.setUserPassword(SecurityUtils.encryptPassword(user.getPassword()));
		iuser.setUserUpdatedDate(new Date());
		
		InstaUserRole role = new InstaUserRole();
		role.setInstaUser(iuser);
		role.setUserRoleCreatedDate(new Date());
		role.setUserRoleRole("ROLE_USER");
		role.setUserRoleUpdatedDate(new Date());
		role.setUserRoleUsername(user.getUsername());
		iuser.setInstaUserRoles(role);
		
		InstaUserProfile profile = new InstaUserProfile();
		profile.setInstaUser(iuser);
		profile.setUserProfileEmail(user.getEmail());
		profile.setUserProfilePhoneNumber(user.getPhonenumber());
		profile.setUserProfileFirstName(user.getFirstname());
		profile.setUserProfileLastName(user.getLastname());
		try {
			profile.setUserProfilePicture(user.getPicture().getBytes());
			profile.setProfileImageType(user.getPicture().getContentType());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		profile.setUserProfileUpdatedDate(new Date());
		profile.setUserProfileCreatedDate(new Date());
		iuser.setInstaUserProfiles(profile);
		instaDao.persistNewUser(iuser);	
	}
	
	@Override
	public InstaUserProfile getUserProfile(String username) {
		// TODO Auto-generated method stub
		return instaDao.getInstaUserProfileByUserName(username);
	}


	@Override
	public LoggedInUser getLoggedInUserDetailsByUserName(String username) {
		// TODO Auto-generated method stub
		
		InstaUserProfile profile = getUserProfile(username);
		return new LoggedInUser(profile.getUserProfileEmail(), profile.getUserProfileFirstName(), profile.getUserProfileLastName());
	}
	
	
	
	
	
	
	
	
	
	
	

}

