package com.insta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.insta.beans.User;
import com.insta.service.InstaService;

@Controller
public class WebController {
	@Autowired
	private InstaService instaService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView getHomePage(){
		
		ModelAndView mav = new ModelAndView("home");
		
		return mav;
		
	}

	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public ModelAndView getSignupPage(){
		
		ModelAndView mav = new ModelAndView("signup");
		mav.addObject("user", new User());
		
		return mav;
		
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ModelAndView getSignupPageWithData(@ModelAttribute("user") User user){
		instaService.saveNewUser(user);
		ModelAndView mav = new ModelAndView("home");
		
		return mav;
		
	}
	
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public ModelAndView getSigninPage(){
		
		ModelAndView mav = new ModelAndView("signin");
		
		return mav;
		
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public ModelAndView getProfilePage(){
		
		ModelAndView mav = new ModelAndView("profile");
		
		return mav;
		
	}
	
	@RequestMapping(value="/images",method=RequestMethod.GET)
	public ModelAndView getImagesPage(){
		
		ModelAndView mav = new ModelAndView("images");
		
		return mav;
		
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public ModelAndView getUploadPage(){
		
		ModelAndView mav = new ModelAndView("upload");
		
		return mav;
		
	}

	
	@RequestMapping(value="/example",method=RequestMethod.GET)
	public ModelAndView getExamplePage(){
		
		ModelAndView mav = new ModelAndView("examples");
		
		return mav;
		
	}


	
}
