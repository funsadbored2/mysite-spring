package com.mysite.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.service.GuestbookService;
import com.mysite.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/api/guestbook/")
public class ApiGuestbookController {

	@Autowired
	private GuestbookService gbService;
	
	@ResponseBody
	@RequestMapping(value="list", method = RequestMethod.POST)
	public List<GuestbookVo> list() {
		
		List<GuestbookVo> list = gbService.list();
		
		return list;
	
	}
	
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public GuestbookVo add(@RequestBody GuestbookVo guestbookVo) {
		
		guestbookVo = gbService.addNo(guestbookVo);
		
		return guestbookVo;
		
	}
	
	
	
}
