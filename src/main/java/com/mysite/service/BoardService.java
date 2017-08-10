package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.BoardDao;
import com.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao bDao;
	
	public List<BoardVo> getBoardList(){
		
		return bDao.getBoardList();
		
	}
	
	public BoardVo read(int no) {
		System.out.println("service");
		System.out.println(no);
		return bDao.read(no);
	}
	
	public int insert(BoardVo insertVo) {
		System.out.println("service");
		System.out.println(insertVo);
		return bDao.insert(insertVo);
	}
	
	public BoardVo modifyRead(int no) {
		System.out.println("service");
		System.out.println(no);
		return bDao.modifyRead(no);
	}

	public int modify(BoardVo modifyVo) {
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
