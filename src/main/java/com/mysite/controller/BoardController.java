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
	
	@RequestMapping(value = "insertform")
	public String insertform(int no){
		
		System.out.println("insertform");
		
		return "board/writeform";
	}
	
	@RequestMapping(value = "insert")
	public String insert(BoardVo insertVo, Model model){
		
		System.out.println("insert");
		
		bService.insert(insertVo);
		
		model.addAttribute("boardRead", insertVo);
		
		return "redirect:/board/read";
	}

	@RequestMapping(value = "modifyform")
	public String modifyform(int no, Model model){
		
		System.out.println("modifyform");
		System.out.println(no);
		BoardVo modifyRead = bService.modifyRead(no);
		
		model.addAttribute("modifyRead", modifyRead);
		
		return "board/modifyform";
	}

	@RequestMapping(value = "modify")
	public String modify(BoardVo modifyVo, Model model){
		
		System.out.println("modifyform");
		System.out.println(modifyVo);
		bService.modify(modifyVo);
			
		return "redirect:/board/list";
	}

	@RequestMapping(value = "delete")
	public String delete(int no){
		
		System.out.println("delete");
		System.out.println(no);
		bService.delete(no);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "search")
	public String search(String kwd) {
		
		
		return null;
	}
	
}
