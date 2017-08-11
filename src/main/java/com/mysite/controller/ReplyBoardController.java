package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.service.ReplyBoardService;
import com.mysite.vo.ReplyBoardVo;


@RequestMapping(value = "replyboard/")
@Controller
public class ReplyBoardController {

	@Autowired
	private ReplyBoardService bService;
	
	@RequestMapping(value = "list")
	public String list(Model model){
		
		List<ReplyBoardVo> list = bService.getBoardList();
		System.out.println(list);
		model.addAttribute("boardList", list);
		
		return "replyboard/list";
	}
	
	@RequestMapping(value = "read")
	public String read(int no, Model model){
		
		System.out.println(no);
		System.out.println("read");
		ReplyBoardVo boardRead = bService.read(no);
		System.out.println(boardRead.toString());
		model.addAttribute("boardRead", boardRead);
		
		return "replyboard/replyRead";
	}
	
	@RequestMapping(value = "insertform")
	public String insertform(int no){
		
		System.out.println("insertform");
		
		return "replyboard/writeform";
	}
	
	@RequestMapping(value = "insert")
	public String insert(ReplyBoardVo insertVo){
		
		System.out.println("insert");
		
		bService.insert(insertVo);
		
		
		return "redirect:/replyboard/list";
	}
	
	@RequestMapping(value = "replyform")
	public String replyform(int no, Model model){
		
		System.out.println("replyform");
		model.addAttribute("replyVo", bService.read(no));
		
		return "replyboard/replyWrite";
	}
	
	@RequestMapping(value = "reply")
	public String reply(ReplyBoardVo replyVo,Model model){
		
		System.out.println("reply");
		System.out.println(replyVo.getNo());
		
		bService.reply(replyVo);
		
		model.addAttribute("boardRead", replyVo);
		
		return "redirect:/replyboard/list";
	}

	@RequestMapping(value = "modifyform")
	public String modifyform(int no, Model model){
		
		System.out.println("modifyform");
		System.out.println(no);
		ReplyBoardVo modifyRead = bService.modifyRead(no);
		
		model.addAttribute("modifyRead", modifyRead);
		
		return "replyboard/modifyform";
	}

	@RequestMapping(value = "modify")
	public String modify(ReplyBoardVo modifyVo, Model model){
		
		System.out.println("modifyform");
		System.out.println(modifyVo);
		bService.modify(modifyVo);
			
		return "redirect:/replyboard/list";
	}

	@RequestMapping(value = "delete")
	public String delete(int no){
		
		System.out.println("delete");
		System.out.println(no);
		bService.delete(no);
		
		return "redirect:/replyboard/list";
	}
	
}
