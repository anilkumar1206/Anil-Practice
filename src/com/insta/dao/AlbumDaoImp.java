package com.insta.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insta.entities.InstaAlbum;


@Repository
public class AlbumDaoImp implements AlbumDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long persistAlbum(InstaAlbum album) {
		// TODO Auto-generated method stub
		InstaAlbum a = (InstaAlbum) sessionFactory.getCurrentSession().merge(album);
		return a.getAlbumId();
	}

	@Override
	public InstaAlbum getAlbumById(Long albumId) {
		// TODO Auto-generated method stub
		return (InstaAlbum) sessionFactory.getCurrentSession().get(InstaAlbum.class, albumId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InstaAlbum> getAlbumsByUserName(String username) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().getNamedQuery("getInstaAlbumByUserName").setParameter("username", username).setCacheable(true).list();
	}

	@Override
	public void deleteAlbumByAlbumId(Long albumId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getAlbumById(albumId));

	}

}
