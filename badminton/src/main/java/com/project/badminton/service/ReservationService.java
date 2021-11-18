package com.project.badminton.service;

import java.util.List;

import com.project.badminton.domain.BookerDTO;
import com.project.badminton.domain.ReservationCourtDTO;
import com.project.badminton.domain.ReservationDTO;
import com.project.badminton.domain.ReservedTimeDTO;

public interface ReservationService {
	int registerReservation(ReservationDTO reservation);	//예약하기
	ReservedTimeDTO getReservedTime(String date, Long courtId);	//예약된 시간을 조회하기
	List<ReservationCourtDTO> getReservationByBooker(BookerDTO booker);	//예약자 정보를 통해 예약 내역 조회하기
	Boolean cancelReservation(Long reservationId);	//예약 취소하기
	Boolean updateReservation(ReservationDTO reservation);	//예약 수정하기
	int getReservationCnt(BookerDTO booker);	//예약자 이름과 전화번호를 가지고 검색된 전체 예약 데이터 수 조회하기
}
