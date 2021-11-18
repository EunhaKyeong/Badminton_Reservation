package com.project.badminton.domain;

import java.util.List;

//배드민턴장 목록 조회 시 클라이언트에게 데이터를 전달할 때 사용되는 Response 데이터 클래스.
public class CourtResDTO {
	private int totalCnt;	//총 데이터 수
	private int pageNo;	//현재 페이지 번호
	private List<CourtDTO> courts;	//조회된 배드민턴장 목록 데이터
	
	public CourtResDTO(int totalCnt, int pageNo, List<CourtDTO> courts) {
		super();
		this.totalCnt = totalCnt;
		this.pageNo = pageNo;
		this.courts = courts;
	}
	
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<CourtDTO> getCourts() {
		return courts;
	}
	public void setCourts(List<CourtDTO> courts) {
		this.courts = courts;
	}
	
	@Override
	public String toString() {
		return "CourtResDTO [totalCnt=" + totalCnt + ", pageNo=" + pageNo + ", courts=" + courts + "]";
	}
}
