package com.insta.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;







@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	@RequestMapping(value="/multifileupload",method=RequestMethod.POST)
	public void multiuploadFilePage(Principal principal, @RequestParam("file") MultipartFile file,HttpServletResponse response ){
		try {
			FileHandler fh = (FileHandler) applicationContext.getBean("filehandler");
			fh.setImageInfo(file.getOriginalFilename(), file.getBytes(), file.getContentType(), file.getSize(),principal.getName());
			taskExecutor.execute(fh);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
