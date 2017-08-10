package com.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVo> getBoardList(){
		
		return sqlSession.selectList("board.getBoardList");
		
	}
	
	public BoardVo read(int no) {
		System.out.println("board");
		System.out.println(no);
		return sqlSession.selectOne("board.getBoardOne", no);
	}

}
