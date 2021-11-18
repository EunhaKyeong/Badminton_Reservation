package com.project.badminton.paging;

//페이징 처리 때 사용하는 클래스
public class Criteria {
	
	private int currentPageNo;	//현재 페이지 번호
	private int recordsPerPage;	//페이지마다 출력할 데이터의 개수
	private int pageSize;	//화면 하단에 출력할 페이지의 크기 지정
	
	public Criteria() {
		this.currentPageNo = 1;
		this.recordsPerPage = 10;
		this.pageSize = 10;
	}
	
	public int getStartPage() {
		return (currentPageNo-1)*recordsPerPage;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Criteria [currentPageNo=" + currentPageNo + ", recordsPerPage=" + recordsPerPage + ", pageSize="
				+ pageSize + "]";
	}

}
