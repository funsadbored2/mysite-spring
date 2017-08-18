package com.mysite.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/guestbook/")
public class ApiGuestbookController {

	@ResponseBody
	@RequestMapping(value="list", method = RequestMethod.POST)
	public String list() {
		
		System.out.println("ajax-list");
		String str = "성공";
		
		return str;
	
	}
	
	
}
