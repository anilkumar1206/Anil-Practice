package com.insta.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insta.beans.Image;
import com.insta.beans.LoggedInUser;
import com.insta.service.ImageService;
import com.insta.service.InstaService;






@RestController
@RequestMapping("/service")
public class RestServiceController {
	@Autowired
	private InstaService instaService;
	@Autowired
	private ImageService imageService;
	
	
	@RequestMapping(value="/user/details",method=RequestMethod.GET)
	public LoggedInUser getLoggedInUserdetails(Principal principal){
		return instaService.getLoggedInUserDetailsByUserName(principal.getName());
	}
	
	@RequestMapping(value="/user/images",method=RequestMethod.GET)
	public List<Image> getImagesForLoggedInUser(Principal principal){
		return imageService.getUserImages(principal.getName());
	}
	
	
	@RequestMapping(value="/image/{imageId}",method=RequestMethod.GET)
	public Image getImageByImageId(Principal principal,@PathVariable("imageId") Long imageId){
		return imageService.getImageByImageId(imageId);
	}
	
	

}
