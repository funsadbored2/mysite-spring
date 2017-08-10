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

	public int delete(int no, String pass) {
		
		return gbDao.delete(no, pass);
	
	}

}
