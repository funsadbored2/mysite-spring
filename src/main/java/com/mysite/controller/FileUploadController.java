package com.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.service.FileUploadService;

@RequestMapping(value = "/fileupload/")
@Controller
public class FileUploadController {
	
	@Autowired
	private FileUploadService uploadService;
	
	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form() {
		
		return "fileupload/form";
		
	}
	
	@RequestMapping(value = "upload", method =RequestMethod.POST)
	public String upload(@RequestParam("email") String email, 
						 @RequestParam("file") MultipartFile file,
						 Model model) {
		
		String saveName = uploadService.restore(file);
		model.addAttribute("saveName", saveName);
		
		return "fileupload/result";
		
	}
	
	
	

}
