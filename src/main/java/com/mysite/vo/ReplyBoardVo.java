package com.mysite.vo;

public class ReplyBoardVo {
	

	private int no;
	private int userNo;
	private int hitNumber;
	private String name;
	private String date;
	private String content;
	private String title;
	private int groupNo;
	private int orderNo;
	private int depth;
	
	ReplyBoardVo() {
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getHitNumber() {
		return hitNumber;
	}

	public void setHitNumber(int hitNumber) {
		this.hitNumber = hitNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "ReplyBoardVo [no=" + no + ", userNo=" + userNo + ", hitNumber=" + hitNumber + ", name=" + name
				+ ", date=" + date + ", content=" + content + ", title=" + title + ", groupNo=" + groupNo + ", orderNo="
				+ orderNo + ", depth=" + depth + "]";
	}
	
	
	
	
}
