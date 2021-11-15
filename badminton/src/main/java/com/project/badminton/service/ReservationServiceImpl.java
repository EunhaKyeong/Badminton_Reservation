package com.project.badminton.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.badminton.domain.BookerDTO;
import com.project.badminton.domain.ReservationCourtDTO;
import com.project.badminton.domain.ReservationDTO;
import com.project.badminton.domain.ReservedTimeDTO;
import com.project.badminton.domain.StartEndTimeDTO;
import com.project.badminton.mapper.ReservationMapper;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationMapper reservationMapper;

	//예약하기
	@Override
	public int registerReservation(ReservationDTO reservation) {
		
		return reservationMapper.insertReservation(reservation);
	}

	//예약된 시간을 조회하기
	@Override
	public ReservedTimeDTO getReservedTime(String date, Long courtId) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ReservationDTO reservation = new ReservationDTO(LocalDate.parse(date, formatter), courtId);
		
		List<StartEndTimeDTO> startEndTimes = reservationMapper.selectStartEndTimeByCourtIdAndDate(reservation);
		
		return getReservedTimeDTO(startEndTimes);
	}
	
	//예약자 정보를 통해 예약 내역 조회하기
	@Override
	public List<ReservationCourtDTO> getReservationByBooker(String name, String phone) {
		BookerDTO booker = new BookerDTO(name, phone);
		
		return reservationMapper.selectReservationListByBooker(booker);
	}
	
	//예약 내역 취소하기
	@Override
	public Boolean cancelReservation(Long reservationId) {
		int isDelete = reservationMapper.deleteReservation(reservationId);
		
		return isDelete>0? true: false;
	}
	
	//프론트에서 이미 예약된 시간은 시작 시간과 종료 시간으로 선택하지 못하도록 하기 위해
	//선택되면 안되는 시간을 리스트 형태로 변환하는 함수.
	//ex) 시작 시간: 14:00, 종료 시간: 18:00 이면
	//시작 시간에서는 14:00, 15:00, 16:00, 17:00 을 선택할 수 없고,
	//종료 시간에서는 15:00, 16:00, 17:00, 18:00 을 선택할 수 없다.
	private ReservedTimeDTO getReservedTimeDTO(List<StartEndTimeDTO> times) {
		List<LocalTime> startTimes = new ArrayList<LocalTime>();
		List<LocalTime> endTimes = new ArrayList<LocalTime>();
		
		for (StartEndTimeDTO time: times) {
			startTimes.add(LocalTime.of(time.getStartTime().getHour(), 0, 0));
			endTimes.add(LocalTime.of(time.getEndTime().getHour(), 0, 0));
			
			for (int hour=time.getStartTime().getHour()+1; hour<time.getEndTime().getHour(); hour++) {
				startTimes.add(LocalTime.of(hour, 0, 0));
			}
		}
		
//		startTimes = startTimes.stream().distinct().collect(Collectors.toList());
//		endTimes = endTimes.stream().distinct().collect(Collectors.toList());
		
		Collections.sort(startTimes);
		Collections.sort(endTimes);
		
		return new ReservedTimeDTO(startTimes, endTimes);
	}

	//예약 수정하기
	@Override
	public Boolean updateReservation(ReservationDTO reservation) {
		//수정이 정상적으로 완료되면 true, 완료되지 않으면 false
		return reservationMapper.updateReservation(reservation)>0? true: false;
	}

}
