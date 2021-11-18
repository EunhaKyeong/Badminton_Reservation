package com.project.badminton.domain;

import java.util.List;

//예약 내역 목록을 전달하는 Response DTO 클래스
public class ReservationResDTO {
	private int totalCnt;
	private int pageNo;
	private List<ReservationCourtDTO> reservations;
	
	public ReservationResDTO(int totalCnt, int pageNo, List<ReservationCourtDTO> reservations) {
		super();
		this.totalCnt = totalCnt;
		this.pageNo = pageNo;
		this.reservations = reservations;
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

	public List<ReservationCourtDTO> getReservations() {
		return reservations;
	}

	public void setReservations(List<ReservationCourtDTO> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "ReservationResDTO [totalCnt=" + totalCnt + ", pageNo=" + pageNo + ", reservations=" + reservations
				+ "]";
	}
	
}
