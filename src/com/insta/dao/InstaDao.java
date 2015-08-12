package com.insta.dao;

import com.insta.entities.InstaUser;
import com.insta.entities.InstaUserProfile;







public interface InstaDao {
	
	public void persistNewUser(InstaUser user);
	
	public InstaUser saveOrUpdate(InstaUser user);
	
	public InstaUserProfile getInstaUserProfileByUserName(String userName);

	public InstaUser getInstaUsedByUserName(String username);

}
