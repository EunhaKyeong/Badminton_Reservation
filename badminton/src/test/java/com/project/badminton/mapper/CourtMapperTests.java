package com.project.badminton.mapper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;

@SpringBootTest
public class CourtMapperTests {
	
	@Autowired
	private CourtMapper courtMapper;
	
	//CourtMapper.java의 selectCourtList 메서드 테스트 코드
	@Test
	public void testOfSelectCourtList() {
		CourtReqDTO courtReqDTO = new CourtReqDTO("인천광역시", "남동구", "구월동");
		List<CourtDTO> courts = courtMapper.selectCourtListByLocation(courtReqDTO);
		
		if (courts.size()!=0) {
			for (CourtDTO court: courts) {
				System.out.println(court.toString());
			}
		}
	}
}
