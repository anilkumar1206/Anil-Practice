package com.insta.service;

import java.util.List;




import com.insta.beans.Image;
import com.insta.beans.ImageComments;
import com.insta.beans.MData;
import com.insta.entities.InstaImage;




public interface ImageService {
	

	
	public List<ImageComments> getImageCommentsByImageId(Long imageId);
	
	public List<MData> getIMageMetaDataByIMageId(Long imageId);
	
	//public Image getImageByImageId(Long imageId);
	
	//public InstaImageData getImageDataByImageId(Long imageId);
	
	public InstaImage getInstaImageById(Long imageId);

	public List<Image> getUserImages(String username);

	public Image getImageByImageId(Long imageId);
	
	//public void addComment(String comment, Long imageId, String username);
	

}
