package com.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
		public List<GuestbookVo> list(){
					
			System.out.println("dao");
			
			return sqlSession.selectList("guestbook.selectAll");
			
		}
		
		public int add(GuestbookVo vo) {
			
			System.out.println(vo.toString());
			
			return sqlSession.insert("guestbook.add", vo);
		}
		
		public int delete(int no, String pass) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("no", no);
			map.put("password", pass);
			
			return sqlSession.delete("guestbook.delete", map);
		}

		public int addNo(GuestbookVo vo){
			
			sqlSession.insert("guestbook.addNo",vo);
			
			return vo.getNo();
		}
		
		public GuestbookVo selectByNo(int no) {
			
			return sqlSession.selectOne("guestbook.selectByNo", no);
			
		}
}
