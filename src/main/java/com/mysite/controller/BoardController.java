package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.service.BoardService;
import com.mysite.vo.BoardVo;


@RequestMapping(value = "board/")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping(value = "list")
	public String list(Model model){
		
		List<BoardVo> list = bService.getBoardList();
		model.addAttribute("boardList", list);
		
		return "board/list";
	}
	
	@RequestMapping(value = "read")
	public String read(int no, Model model){
		
		System.out.println(no);
		System.out.println("read");
		 BoardVo boardRead = bService.read(no);
		 model.addAttribute("boardRead", boardRead);
		
		return "board/read";
	}
	
	

}
