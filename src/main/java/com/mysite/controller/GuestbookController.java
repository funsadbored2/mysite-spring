package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysite.service.GuestbookService;
import com.mysite.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/guestbook/")
public class GuestbookController {

	@Autowired
	private GuestbookService gbService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {

		System.out.println("lis들어옴");
		
		List<GuestbookVo> list = gbService.list();
		System.out.println(list.toString());
		
		model.addAttribute("list", list);

		return "guestbook/list";

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(GuestbookVo vo) {

		System.out.println(vo.toString());
		int no = gbService.add(vo);
		System.out.println(no + "번");

		return "redirect:/guestbook/list";
	}

	@RequestMapping(value = "deleteform", method = RequestMethod.GET)
	public String deleteform(int no) {

		return "guestbook/deleteform";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(int no, String password) {

		System.out.println("delete들어움");
		System.out.println(no+"," +password);
		gbService.delete(no, password);

		return "redirect:/guestbook/list";
	}

}
