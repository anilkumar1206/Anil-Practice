package com.insta.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insta.entities.InstaUser;
import com.insta.entities.InstaUserProfile;






@Repository
@Transactional
public class InstaDaoImp implements InstaDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistNewUser(InstaUser user) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public InstaUser saveOrUpdate(InstaUser user) {
		// TODO Auto-generated method stub
		return (InstaUser) sessionFactory.getCurrentSession().merge(user);
	}

	@Override
	public InstaUserProfile getInstaUserProfileByUserName(String userName) {
		// TODO Auto-generated method stub
		return (InstaUserProfile) sessionFactory.getCurrentSession().getNamedQuery("getInstaUserByUserName").setCacheable(true).setParameter("username", userName).list();
	}

	@Override
	public InstaUser getInstaUsedByUserName(String username) {
		// TODO Auto-generated method stub
		return (InstaUser) sessionFactory.getCurrentSession().getNamedQuery("getInstaUserByUserName").setCacheable(true).setParameter("username", username).list().get(0);
	}
	

}
