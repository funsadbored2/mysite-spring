package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.service.ReplyBoardService;
import com.mysite.vo.Paging;
import com.mysite.vo.ReplyBoardVo;


@RequestMapping(value = "replyboard/")
@Controller
public class ReplyBoardController {

	@Autowired
	private ReplyBoardService bService;
	
	@RequestMapping(value = "list")
	public String list(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo, 
						Model model){
		
	/*	String kwd = null;*/
		Paging paging = new Paging(pageNo,3);
		paging.setTotalCount(bService.searchTotalCount());
		
		List<ReplyBoardVo> list = bService.getBoardList(paging);
		System.out.println(list);
		
		model.addAttribute("boardList", list);
		model.addAttribute("paging", paging);
		
		return "replyboard/list";
	}
	
	@RequestMapping(value = "search")
	public String search(String kwd,Model model){
		System.out.println("search들어옴");
		System.out.println("kwd");
		
		return  "redirect:/replyboard/list";
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
		System.out.println(modifyRead.toString());
		
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

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(ReplyBoardVo deleteVo){
		
		System.out.println("delete");
		bService.delete(deleteVo);
		
		return "redirect:/replyboard/list";
	}
	
}
