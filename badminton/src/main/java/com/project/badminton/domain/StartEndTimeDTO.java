package com.project.badminton.domain;

import java.time.LocalTime;

//DB에서 예약된 시간을 조회해 서비스에 전달하는 DTO
public class StartEndTimeDTO {

	private LocalTime startTime;
	private LocalTime endTime;
	
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
		return "StartEndTimeDTO [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
}
