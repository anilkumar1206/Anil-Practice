package com.insta.dao;


import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insta.beans.Image;
import com.insta.entities.InstaImage;
import com.insta.entities.InstaImageComments;
import com.insta.entities.InstaImageMetadata;




@Repository
@Transactional
public class ImageDaoImp implements ImageDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void persistImage(InstaImage image) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(image);

	}

	@Override
	public void saveOrUpdate(InstaImage image) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(image);

	}

	

	@Override
	public Set<InstaImageComments> getImageComments(Long imageId) {
		// TODO Auto-generated method stub
		InstaImage image =  (InstaImage) sessionFactory.getCurrentSession().load(InstaImage.class, imageId);
		return image.getInstaImageCommentses();
	}

	@Override
	public InstaImage getInstaImageByImageId(Long imageId) {
		// TODO Auto-generated method stub
		return (InstaImage) sessionFactory.getCurrentSession().load(InstaImage.class, imageId);
	}

	@Override
	public Set<InstaImageMetadata> getImageMetaDataByIMageId(Long imageId) {
		// TODO Auto-generated method stub
		return getInstaImageByImageId(imageId).getInstaImageMetadatas();
	}

	@Override
	public void deleteImageByImageId(Long imageId) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(getInstaImageByImageId(imageId));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Image> getImagesByUserName(String username) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().getNamedQuery("getInstaImagesByUserName").setParameter("username", username).setCacheable(true).list();
	}

}
