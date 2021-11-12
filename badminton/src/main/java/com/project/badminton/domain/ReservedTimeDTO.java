package com.project.badminton.domain;

import java.time.LocalTime;
import java.util.List;

//서비스에서 예약된 시간을 컨트롤러에 전달하는 DTO
public class ReservedTimeDTO {
	private List<LocalTime> reservedStartTime;
	private List<LocalTime> reservedEndTime;
	
	public ReservedTimeDTO(List<LocalTime> reservedStartTime, List<LocalTime> reservedEndTime) {
		super();
		this.reservedStartTime = reservedStartTime;
		this.reservedEndTime = reservedEndTime;
	}
	
	public List<LocalTime> getReservedStartTime() {
		return reservedStartTime;
	}
	public void setReservedStartTime(List<LocalTime> reservedStartTime) {
		this.reservedStartTime = reservedStartTime;
	}
	public List<LocalTime> getReservedEndTime() {
		return reservedEndTime;
	}
	public void setReservedEndTime(List<LocalTime> reservedEndTime) {
		this.reservedEndTime = reservedEndTime;
	}
}
