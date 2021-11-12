package com.project.badminton.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.badminton.domain.BookerDTO;
import com.project.badminton.domain.ReservationCourtDTO;
import com.project.badminton.domain.ReservationDTO;
import com.project.badminton.domain.StartEndTimeDTO;

@SpringBootTest
public class ReservationMapperTests {
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	//ReservationMapper.java의 insertReservation 메서드 테스트
	@Test
	void testOfInsertReservation() {
		try {
			ReservationDTO reservation = new ReservationDTO(LocalDate.of(2021, 11, 11), LocalTime.of(15, 0, 0), LocalTime.of(17, 0, 0), "경은하", "01012345678", 1L);
			System.out.println(reservation.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//ReservationMapper.java의 selectStartEndTimeByCourtIdAndDate 메서드 테스트
	@Test
	void testOfSelectStartEndTimeByCourtIdAndDate() {
		try {
			ReservationDTO reservation = new ReservationDTO(LocalDate.of(2021, 11, 11), 1L);
			List<StartEndTimeDTO> reservationTimes = reservationMapper.selectStartEndTimeByCourtIdAndDate(reservation);
			
			for (StartEndTimeDTO reservationTime: reservationTimes) {
				System.out.println(reservationTime.toString());
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ReservationMapper.java의 selectReservationListByBooker 메서드 테스트
	@Test
	void testOfSelectReservationListByBooker() {
		try {
			BookerDTO booker = new BookerDTO("경은하", "01012345678");
			List<ReservationCourtDTO> reservations = reservationMapper.selectReservationListByBooker(booker);
			
			for (ReservationCourtDTO r: reservations) {
				System.out.println(r.toString());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//ReservationMapper.java의 deleteReservation 메서드 테스트
	@Test
	void testOfDeleteReservation() {
		try {
			int isDelete = reservationMapper.deleteReservation(1L);
			System.out.println(isDelete);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testOfUpdateReservation() {
		try {
			ReservationDTO reservation = new ReservationDTO(1L, LocalDate.of(2021, 11, 12), LocalTime.of(14, 0), LocalTime.of(15, 0), "경은하", "01012345678", 2L);
			int isUpdate = reservationMapper.updateReservation(reservation);
			System.out.println(isUpdate);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
