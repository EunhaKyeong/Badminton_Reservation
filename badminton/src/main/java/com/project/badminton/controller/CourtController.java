package com.project.badminton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;
import com.project.badminton.service.CourtService;

@RestController
@RequestMapping("/courts")
public class CourtController {

	@Autowired
	private CourtService courtService;
	
	//위치를 검색하여 배드민턴장 목록 조회하기
	@GetMapping() 
	ResponseEntity<List<CourtDTO>> getCourtList(@RequestParam(value="metropolitanCity") String metropolitanCity, @RequestParam(value="sigungu") String sigungu, @RequestParam(value="eupmyeonri") String eupmyeonri) {
		CourtReqDTO reqData = new CourtReqDTO(metropolitanCity, sigungu, eupmyeonri);
		List<CourtDTO> courts = courtService.getCourtListByLocation(reqData);
		
		if (courts.size()==0) {	
			//검색 결과 해당 위치에 존재하는 배드민턴 장소가 없다면 204 Status Code 전달
			return ResponseEntity.noContent().build();
		} else {
			//검색 결과 해당 위치에 존재하는 배드민턴 장소가 있다면 200 Status Code와 배드민턴장 목록 데이터 전달.
			return ResponseEntity.ok(courts);
		}
	}
}
