package com.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.GuestbookDao;
import com.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao gbDao;

	public List<GuestbookVo> list() {
		System.out.println("service");
		return gbDao.list();

	}

	public int add(GuestbookVo vo) {
		
		System.out.println(vo.toString());
		
		return gbDao.add(vo);

	}
	
	public GuestbookVo addNo(GuestbookVo vo) {
		int no = gbDao.addNo(vo);
		vo = gbDao.selectByNo(no);
		return vo;
	
	} 

	public List<GuestbookVo> delete(int no, String pass) {
		
		System.out.println("delete service");
		gbDao.delete(no, pass);
		
		return gbDao.list();
				
	
	}

}
