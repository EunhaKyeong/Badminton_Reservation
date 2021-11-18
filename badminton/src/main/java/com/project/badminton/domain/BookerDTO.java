package com.project.badminton.domain;

import com.project.badminton.paging.Criteria;

//예약 목록 조회에서 사용되는 Request 데이터 클래스
//페이징 처리 기능이 있어 Criteria 클래스를 상속받는다.
public class BookerDTO extends Criteria {
	private String name;
	private String phone;
	
	public BookerDTO(String name, String phone, int pageNo) {
		super();
		this.name = name;
		this.phone = phone;
		this.setCurrentPageNo(pageNo);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
