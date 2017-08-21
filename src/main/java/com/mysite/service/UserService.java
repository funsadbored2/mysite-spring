package com.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.repository.UserDao;
import com.mysite.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public int join(UserVo userVo) {
		
		return userDao.insert(userVo);
	
	}
	
	public UserVo getUser(String email, String password) {
		
		return userDao.getUser(email, password);
	
	}
	
	public UserVo getUser(int no) {
	
		return userDao.getUser(no);
	}
	
	public int updateUser(UserVo userVo) {
		
		
		return userDao.updateUser(userVo);
		
	}
	
	public Boolean emailValidation(String email) {
		System.out.println(email + "유저 서지스 들어옴");
		UserVo checkVo = userDao.emailValidation(email);
		
		boolean validation = true;
		
		if(checkVo == null) {
			validation = true;
		}else if(checkVo != null) {
			validation = false;
		}
		
		return validation;
	}
	
}
