package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.ReplyBoardDao;
import com.mysite.vo.ReplyBoardVo;

@Service
public class ReplyBoardService {
	
	@Autowired
	private ReplyBoardDao bDao;
	
	public List<ReplyBoardVo> getBoardList(){
		
		return bDao.getBoardList();
		
	}
	
	public ReplyBoardVo read(int no) {
		System.out.println("service");
		System.out.println(no);
		ReplyBoardVo vo = bDao.read(no);
		if(vo != null) {
			bDao.hitCount(no);
		}
		return vo;
	}
	
	public int insert(ReplyBoardVo insertVo) {
		System.out.println("service");
		System.out.println(insertVo);
		return bDao.insert(insertVo);
	}
	
	public int reply(ReplyBoardVo replyVo) {
		
		bDao.replyIncrease(replyVo.getGroupNo(),replyVo.getOrderNo());
		
		return bDao.replyInsert(replyVo);
	}
	
	public ReplyBoardVo modifyRead(int no) {
		System.out.println("service");
		System.out.println(no);
		return bDao.modifyRead(no);
	}

	public int modify(ReplyBoardVo modifyVo) {
		System.out.println("service");
		System.out.println(modifyVo.toString());
		return bDao.modify(modifyVo);
	}

	public int delete(int no) {
		System.out.println("service");
		System.out.println(no);
		return bDao.delete(no);
	} 
}
