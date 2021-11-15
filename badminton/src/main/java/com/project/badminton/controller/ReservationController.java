package com.project.badminton.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.badminton.domain.ReservationCourtDTO;
import com.project.badminton.domain.ReservationDTO;
import com.project.badminton.domain.ReservedTimeDTO;
import com.project.badminton.service.ReservationService;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	//예약하기
	@PostMapping()
	private ResponseEntity<String> registerReservation(@RequestBody ReservationDTO reservation) throws URISyntaxException {
		
		try {
			int result = reservationService.registerReservation(reservation);
			
			if (result==1) {	//성공적으로 예약내역이 DB에 저장되면 201 Status Code
				return ResponseEntity.created(new URI("/")).body("success");
			} else {
				return ResponseEntity.internalServerError().body("fail");
			}
		} catch(DataIntegrityViolationException e) {	//클라이언트가 필수적으로 보내야하는 데이터를 보내지 않은 경우 -> 400
			e.printStackTrace();
			
			return ResponseEntity.badRequest().body("fail");
		} catch (Exception e) {	//서버 에러 -> 500
			e.printStackTrace();
		
			return ResponseEntity.internalServerError().body("fail");
		}
		
	}
	
	//해당 날짜에 예약하고자 하는 배드민턴장에 이미 예약된 시간 데이터를 조회할 때 요청하는 api
	@GetMapping("/reserved")
	private ResponseEntity<ReservedTimeDTO> getReservedTime(@RequestParam(value="date", required=true) String date, @RequestParam(value="courtId", required=true) Long courtId) {
		ReservedTimeDTO reservedTime = reservationService.getReservedTime(date, courtId);
		
		return ResponseEntity.ok(reservedTime);
	}
	
	//예약자 정보를 활용해 예약 내역을 조회하는 API
	@GetMapping()
	private ResponseEntity<List<ReservationCourtDTO>> getReservationsByBooker(@RequestParam(value="name", required=true) String name, @RequestParam(value="phone", required=true) String phone) {
		List<ReservationCourtDTO> reservations = reservationService.getReservationByBooker(name, phone);
		
		if (reservations.size()==0) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(reservations);
		}
	}
	
	//예약 취소하기
	@DeleteMapping("/{id}")
	private ResponseEntity<Boolean> cancelReservation(@PathVariable Long id) {
		Boolean isDelete = reservationService.cancelReservation(id);
		
		//삭제된 데이터(isDelete=1)가 없으면 responseBody에 false를 반환하고, 있으면 true를 반환한다.
		return ResponseEntity.ok().body(isDelete);
	}
	
	//예약 수정하기
	@PatchMapping("/{id}")
	private ResponseEntity<String> updateReservation(@PathVariable(value="id", required=true) Long id, @RequestBody ReservationDTO reservation) {
		try {
			Boolean result = reservationService.updateReservation(reservation);
			
			if (result)
				return ResponseEntity.created(null).body("success");
			else
				return ResponseEntity.internalServerError().body("fail");
		} catch(Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.internalServerError().body("fail");
		}
	}
	
}
