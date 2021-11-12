package com.project.badminton.mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;
import com.project.badminton.domain.ReservationDTO;

@SpringBootTest
public class CourtMapperTests {
	
	@Autowired
	private CourtMapper courtMapper;
	
	//CourtMapper.java의 selectCourtListByLocation 메서드 테스트 코드
	@Test
	public void testOfSelectCourtListByLocation() {
		CourtReqDTO courtReqDTO = new CourtReqDTO("인천광역시", "남동구", "구월동");
		List<CourtDTO> courts = courtMapper.selectCourtListByLocation(courtReqDTO);
		
		if (courts.size()!=0) {
			for (CourtDTO court: courts) {
				System.out.println(court.toString());
			}
		}
	}
	
	//CourtMapper.java의 selectCourtListByName 메서드 테스트 코드
	@Test
	void testOfSelectCourtListByName() {
		List<CourtDTO> courts = courtMapper.selectCourtListByName("향촌");
		
		if (courts.size()!=0) {
			for (CourtDTO court: courts) {
				System.out.println(court.toString());
			}
		}
	}
}
