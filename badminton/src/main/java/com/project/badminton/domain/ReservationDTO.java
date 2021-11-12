package com.project.badminton.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//reservation 테이블 DTO
public class ReservationDTO {
	private Long id;
	private LocalDate reservationDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private LocalDateTime insertTime;
	private Boolean isDelete = false;
	private String userName;
	private String userPhone;
	private Long courtId;
	
	public ReservationDTO() {
		
	}
	
	public ReservationDTO(LocalDate reservationDate, Long courtId) {
		this.reservationDate = reservationDate;
		this.courtId = courtId;
	}
	
	public ReservationDTO(LocalDate reservationDate, LocalTime startTime, LocalTime endTime, String userName, String userPhone, Long courtId) {
		this.reservationDate = reservationDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.userName = userName;
		this.userPhone = userPhone;
		this.courtId = courtId;
	}
	
	public ReservationDTO(Long id, LocalDate reservationDate, LocalTime startTime, LocalTime endTime, String userName,
			String userPhone, Long courtId) {
		super();
		this.id = id;
		this.reservationDate = reservationDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.userName = userName;
		this.userPhone = userPhone;
		this.courtId = courtId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public LocalDateTime getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(LocalDateTime insertTime) {
		this.insertTime = insertTime;
	}
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Long getCourtId() {
		return courtId;
	}
	public void setCourtId(Long courtId) {
		this.courtId = courtId;
	}
	
	@Override
	public String toString() {
		return "ReservationDTO [id=" + id + ", reservationDate=" + reservationDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", insertTime=" + insertTime + ", isDelete=" + isDelete + ", userName="
				+ userName + ", userPhone=" + userPhone + ", courtId=" + courtId + "]";
	}
}
