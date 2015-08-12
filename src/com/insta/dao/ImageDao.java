package com.insta.dao;


import java.util.List;
import java.util.Set;

import com.insta.beans.Image;
import com.insta.entities.InstaImage;
import com.insta.entities.InstaImageComments;
import com.insta.entities.InstaImageMetadata;





public interface ImageDao {
	
public void persistImage(InstaImage image);
	
	public void saveOrUpdate(InstaImage image);
	
	public Set<InstaImageComments> getImageComments(Long imageId);
	
	public InstaImage getInstaImageByImageId(Long imageId);
	
	public Set<InstaImageMetadata> getImageMetaDataByIMageId(Long imageId);
	
	public void deleteImageByImageId(Long imageId);

	public List<Image> getImagesByUserName(String username);

}
