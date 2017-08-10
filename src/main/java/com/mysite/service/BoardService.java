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
	

}
