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
	
	public int hitCount(int no) {
		
		System.out.println("hitcount board");
		System.out.println(no);
		return sqlSession.update("board.updateHitNum", no);

	}

	public int insert(BoardVo insertVo) {
		System.out.println("board");
		System.out.println(insertVo);
		return sqlSession.insert("board.insert",insertVo);
	}

	public BoardVo modifyRead(int no) {
		System.out.println("board");
		System.out.println(no);
		return sqlSession.selectOne("board.modifyRead", no);
	}

	public int modify(BoardVo modifyVo) {
		System.out.println("board");
		System.out.println(modifyVo.toString());
		return sqlSession.update("board.modify", modifyVo);
	}

	public int delete(int no) {
		System.out.println("board");
		System.out.println(no);
		return sqlSession.delete("board.delete", no);
	}
}
