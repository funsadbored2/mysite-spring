package com.mysite.vo;

public class BoardVo {

	private int no;
	private int userNo;
	private int hitNumber;
	private String name;
	private String date;
	private String content;
	private String title;
	
public BoardVo() {
		
	}

	public BoardVo(int userNo, String title, String content) {
		
	}
	
	public BoardVo(int no, int userNo, int hitNumber, String name, String date, String content, String title) {
		super();
		this.no = no;
		this.userNo = userNo;
		this.hitNumber = hitNumber;
		this.name = name;
		this.date = date;
		this.content = content;
		this.title = title;
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

	public void setUserNo(int user_no) {
		this.userNo = user_no;
	}

	public int getHitNumber() {
		return hitNumber;
	}

	public void setHitNumber(int hit_number) {
		this.hitNumber = hit_number;
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

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", user_no=" + userNo + ", hit_number=" + hitNumber + ", name=" + name
				+ ", date=" + date + ", content=" + content + ", title=" + title + "]";
	}
	
}
