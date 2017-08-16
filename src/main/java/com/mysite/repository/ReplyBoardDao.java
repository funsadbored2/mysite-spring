package com.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysite.vo.Paging;
import com.mysite.vo.ReplyBoardVo;
@Repository
public class ReplyBoardDao {
	
	@Autowired
	private SqlSession sql;
	
	public List<ReplyBoardVo> getBoardList(Paging paging){
		
		
		List<ReplyBoardVo> list = sql.selectList("replyboard.getBoardList",paging);
		
		return list;
		
	}
	
	public int searchTotalCount() {
		
		int count = sql.selectOne("replyboard.totalCount");
		return count;
				
	}
	
	public List<ReplyBoardVo> search(String kwd){
		
		return sql.selectList("replyboard.search", kwd);
	}
	
	public ReplyBoardVo read(int no) {
		System.out.println("board");
		System.out.println(no);
		
		return sql.selectOne("replyboard.getBoardOne", no);
	}
	
	public int hitCount(int no) {
		
		System.out.println("hitcount board");
		System.out.println(no);
		return sql.update("replyboard.updateHitNum", no);

	}

	public int insert(ReplyBoardVo insertVo) {
		System.out.println("board");
		System.out.println(insertVo);
		return sql.insert("replyboard.insert",insertVo);
	}

	public ReplyBoardVo modifyRead(int no) {
		System.out.println("board");
		System.out.println(no);
		return sql.selectOne("replyboard.modifyRead", no);
	}

	public int modify(ReplyBoardVo modifyVo) {
		System.out.println("board");
		System.out.println(modifyVo.toString());
		return sql.update("replyboard.modify", modifyVo);
	}

	public int delete(ReplyBoardVo deleteVo) {
		System.out.println("board");
		System.out.println(deleteVo);
		return sql.delete("replyboard.delete", deleteVo);
	}
	
	public int replyIncrease(int groupno, int orderno) {
		System.out.println("replyIncreas");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("groupno", groupno);
		map.put("orderno", orderno);
		System.out.println("replyIncreas 나옴");
		System.out.println(orderno);
		
		return sql.update("replyboard.replyIncreas",map);
	}
	
	public int replyInsert(ReplyBoardVo replyVo){
		
		int orderNo = replyVo.getOrderNo();
		int depth = replyVo.getDepth();
		++orderNo;
		++depth;
		System.out.println(orderNo+","+depth);
		replyVo.setOrderNo(orderNo);
		replyVo.setDepth(depth);
		
		return sql.insert("replyboard.replyInsert",replyVo);
	}
}
