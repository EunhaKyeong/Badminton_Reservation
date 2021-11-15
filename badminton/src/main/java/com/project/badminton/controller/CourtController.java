package com.project.badminton.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;
import com.project.badminton.service.CourtService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/courts")
public class CourtController {

	@Autowired
	private CourtService courtService;
	
	//배드민턴장 목록 조회하기
	@GetMapping() 
	ResponseEntity<List<CourtDTO>> getCourtListByLocation(@RequestParam(value="metropolitanCity", required=false) String metropolitanCity, @RequestParam(value="sigungu", required=false) String sigungu, @RequestParam(value="eupmyeonri", required=false) String eupmyeonri, @RequestParam(value="name", required=false) String name) throws UnsupportedEncodingException {
		List<CourtDTO> courts = new ArrayList<CourtDTO>();
		
		if (metropolitanCity!=null) {	//장소(광역시도/시군구/읍면동리)를 검색해 배드민턴장 목록 검색하기
			CourtReqDTO reqData = new CourtReqDTO(metropolitanCity, sigungu, eupmyeonri);
			courts = courtService.getCourtListByLocation(reqData);
		} else {	//장소명을 검색해 배드민턴장 목록 검색하기
			courts = courtService.getCourtListByName(name);
		}
		
		if (courts.size()==0) {	
			//검색 결과 해당 위치에 존재하는 배드민턴 장소가 없다면 204 Status Code 전달
			return ResponseEntity.noContent().build();
		} else {
			//검색 결과 해당 위치에 존재하는 배드민턴 장소가 있다면 200 Status Code와 배드민턴장 목록 데이터 전달.
			return ResponseEntity.ok(courts);
		}
	}
}
