package com.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.UserService;
import com.mysite.vo.UserVo;

@Controller
@RequestMapping(value = "user/")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "joinform", method = RequestMethod.GET)
	public String joinform() {

		System.out.println("controller joinform들어옴");
		return "user/joinform";
	}

	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(UserVo userVo) {

		System.out.println("controller join 들어옴");
		System.out.println(userVo.toString());

		userService.join(userVo);
		return "user/joinsuccess";

	}

	@RequestMapping(value = "loginform", method = RequestMethod.GET)
	public String loginform() {
		System.out.println("loginform들어옴");
		return "user/loginform";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		System.out.println("login 들어옴");
		UserVo authUser = userService.getUser(email, password);
		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		} else {
			return "redirect:/user/loginform?result=fail";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/main";
	}

	@RequestMapping(value = "modifyform", method = RequestMethod.GET)
	public String modifyform(HttpSession session, Model model) {
		System.out.println("update form에 들어옴");
		UserVo vo = (UserVo) session.getAttribute("authUser");
		
		UserVo userVo = userService.getUser(vo.getNo());
		
		model.addAttribute("userVo",userVo);
		
		return "user/modifyform";
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(UserVo userVo) {
		
		
		return "redirect:/main";
	}

}
