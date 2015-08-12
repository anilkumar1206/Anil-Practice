package com.insta.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;











import com.insta.beans.Image;
import com.insta.beans.ImageComments;
import com.insta.beans.MData;
import com.insta.dao.AlbumDao;
import com.insta.dao.ImageDao;
import com.insta.dao.InstaDao;
import com.insta.entities.InstaAlbum;
import com.insta.entities.InstaImage;
import com.insta.entities.InstaImageComments;
import com.insta.entities.InstaImageMetadata;






@Service
@Transactional
public class ImageServiceImp implements ImageService {

	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private InstaDao instaDao;
	@Autowired
	private AlbumDao albumDao;
	
	@Override
	public List<ImageComments> getImageCommentsByImageId(Long imageId) {
		List<ImageComments> comments = new ArrayList<ImageComments>();
		InstaImage image = imageDao.getInstaImageByImageId(imageId);
		if(CollectionUtils.isNotEmpty(image.getInstaImageCommentses())){
		for(InstaImageComments c:image.getInstaImageCommentses()){
			ImageComments comment = new ImageComments(c.getImageComentsId(), imageId, c.getInstaUser().getUserId(), c.getInstaUser().getUserUsername(), c.getImageComments(), c.getImageCommentsCreatedDate());
			comments.add(comment);
		}
		}
		return comments;
	}

	@Override
	public List<MData> getIMageMetaDataByIMageId(Long imageId) {
		// TODO Auto-generated method stub
		List<MData> md = new ArrayList<MData>();
		for(InstaImageMetadata data: imageDao.getImageMetaDataByIMageId(imageId)){
			MData meta = new MData(data.getImageMetadataId(), data.getPropertyName(), data.getPropertyValue());
			md.add(meta);
		}
		return md;
	}

	@Override
	public Image getImageByImageId(Long imageId) {
		// TODO Auto-generated method stub
		String albumName = "";
		String albumDescription = "";
		InstaImage image = imageDao.getInstaImageByImageId(imageId);
		if(0!= image.getImageId()){
			InstaAlbum album = albumDao.getAlbumById(image.getImageId());
			albumName = album.getAlbumName();
			albumDescription = album.getAlbumDescription();
		}
		return new Image(image.getImageId(), image.getImageName(), image.getImageDescription(), image.getImageContentType(), image.getImageSize(), image.isImageIsPrivate(), image.getImageCreatedDate(), albumName, albumDescription,new Long(image.getInstaImageCommentses().size()),image.getInstaUser().getUserUsername());
	}

//	@Override
//	public InstaImageData getImageDataByImageId(Long imageId) {
//		// TODO Auto-generated method stub
//		InstaImage image = imageDao.getInstaImageByImageId(imageId);
//		return image.getInstaImageDatas();
//	}

	@Override
	public InstaImage getInstaImageById(Long imageId) {
		// TODO Auto-generated method stub
		return imageDao.getInstaImageByImageId(imageId);
	}

	@Override
	public List<Image> getUserImages(String username) {
		// TODO Auto-generated method stub
		return imageDao.getImagesByUserName(username);
	}

	

//	@Override
//	public void addComment(String comment, Long imageId, String username) {
//		// TODO Auto-generated method stub
//
//		InstaImage image = imageDao.getInstaImageByImageId(imageId);
//		InstaImageComments comments = new InstaImageComments();
//		comments.setInstaImage(image);
//		comments.setInstaUser(instaDao.getInstaUserProfileByUserName(username));
//		comments.setImageComments(comment);
//		comments.setImageCommentsCreatedDate(new Date());
//		image.getInstaImageCommentses().add(comments);
//		imageDao.saveOrUpdate(image);
//	}

}
