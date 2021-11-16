package com.project.badminton.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationCourtDTO {

	private Long reservationId;
	private String booker;
	private Long courtId;
	private String court;
	private String link;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public String getBooker() {
		return booker;
	}
	public void setBooker(String booker) {
		this.booker = booker;
	}
	public Long getCourtId() {
		return courtId;
	}
	public void setCourtId(Long courtId) {
		this.courtId = courtId;
	}
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
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
	
	@Override
	public String toString() {
		return "ReservationCourtDTO [reservationId=" + reservationId + ", booker=" + booker + ", courtId=" + courtId
				+ ", court=" + court + ", link=" + link + ", date=" + date + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
}
