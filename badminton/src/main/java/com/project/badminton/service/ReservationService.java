package com.project.badminton.service;

import java.util.List;

import com.project.badminton.domain.ReservationCourtDTO;
import com.project.badminton.domain.ReservationDTO;
import com.project.badminton.domain.ReservedTimeDTO;

public interface ReservationService {
	int registerReservation(ReservationDTO reservation);	//예약하기
	ReservedTimeDTO getReservedTime(String date, Long courtId);	//예약된 시간을 조회하기
	List<ReservationCourtDTO> getReservationByBooker(String name, String phone);	//예약자 정보를 통해 예약 내역 조회하기
	Boolean cancelReservation(Long reservationId);	//예약 취소하기
}
