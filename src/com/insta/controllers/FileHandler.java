package com.insta.controllers;



import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.insta.dao.AlbumDao;
import com.insta.dao.ImageDao;
import com.insta.dao.InstaDao;
import com.insta.entities.InstaImage;
import com.insta.entities.InstaImageData;
import com.insta.entities.InstaImageMetadata;
import com.insta.entities.InstaUser;
import com.insta.utils.ImageUtils;





@Scope("prototype")
@Component("filehandler")
public class FileHandler implements Runnable{
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private InstaDao instaDao;
	
	@Autowired
	private AlbumDao albumDao;
	
	
	private InstaImage image;
	

	public void  setImageInfo(String fileName, byte[] filedata,
			String contentType, Long fileSize,String username){
		this.image = new InstaImage();
		InstaUser user = instaDao.getInstaUsedByUserName(username);
		image.setInstaUser(user);
		image.setImageContentType(contentType);
		image.setImageCreatedDate(new Date());
		image.setImageDescription("");
		image.setImageIsPrivate(Boolean.TRUE);
		image.setImageName(fileName);
		image.setImageSize(fileSize);
		image.setImageUpdatedDate(new Date());
		
		
		InstaImageData data = new InstaImageData();
		data.setInstaImage(image);
		data.setImageBytes(filedata);
		data.setImageDataCreatedDate(new Date());
		image.setInstaImageData(data);
		Set<InstaImageMetadata> flickrImageMetadata = new HashSet<InstaImageMetadata>();
		Map<String,String> props = ImageUtils.getImageMetadata(filedata);
		if(!props.isEmpty()){
			for (Map.Entry<String, String> entry : props.entrySet()) {
			    InstaImageMetadata metadata = new InstaImageMetadata();
			    metadata.setInstaImage(image);
			    metadata.setImageMetadataCreatedDate(new Date());
			    metadata.setPropertyName(entry.getKey());
			    metadata.setPropertyValue(entry.getValue());
			    flickrImageMetadata.add(metadata);
			}
			image.setInstaImageMetadatas(flickrImageMetadata);
			
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		imageDao.persistImage(image);
	}

}
