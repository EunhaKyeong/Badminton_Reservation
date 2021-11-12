package com.project.badminton.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.badminton.domain.BookerDTO;
import com.project.badminton.domain.ReservationCourtDTO;
import com.project.badminton.domain.ReservationDTO;
import com.project.badminton.domain.StartEndTimeDTO;

@Mapper
public interface ReservationMapper {
	public int insertReservation(ReservationDTO reservation);	//예약 데이터 추가하기
	public List<StartEndTimeDTO> selectStartEndTimeByCourtIdAndDate(ReservationDTO reservation);	//배드민턴장 Id와 예약 날짜를 검색해 예약돼 있는 시간 조회하기
	public List<ReservationCourtDTO> selectReservationListByBooker(BookerDTO booker);	//예약자 이름과 전화번호를 검색해 예약 목록 조회하기
	public int deleteReservation(Long reservationId);	//예약 내역 취소
	public int updateReservation(ReservationDTO reservation);	//예약 내역 수정
}
