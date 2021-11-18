package com.project.badminton.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;
import com.project.badminton.domain.CourtResDTO;
import com.project.badminton.service.CourtService;

@RestController
@RequestMapping("/courts")
public class CourtController {

	@Autowired
	private CourtService courtService;
	
	//배드민턴장 목록 조회하기
	@GetMapping() 
	ResponseEntity<CourtResDTO> getCourtListByLocation(@RequestParam(value="metropolitanCity", required=false) String metropolitanCity, 
														@RequestParam(value="sigungu", required=false) String sigungu, 
														@RequestParam(value="eupmyeonri", required=false) String eupmyeonri, 
														@RequestParam(value="name", required=false) String name, 
														@RequestParam(value="pageNo", required=true) int pageNo) throws UnsupportedEncodingException {
		
		List<CourtDTO> courts = new ArrayList<CourtDTO>();	//DB에서 전달받은 배드민턴장 목록을 저장하는 변수
		CourtReqDTO reqData;	//요청받은 데이터를 저장하는 클래스
		int cnt = 0;	//courts의 데이터 개수를 저장하는 변수 
		
		if (metropolitanCity!=null) {	//장소(광역시도/시군구/읍면동리)를 검색해 배드민턴장 목록 검색하기
			reqData = new CourtReqDTO(metropolitanCity, sigungu, eupmyeonri, pageNo);
			courts = courtService.getCourtListByLocation(reqData);	//검색 조건에 맞는 배드민턴장 목록을 조회한다.
			cnt = courtService.getCourtCntByLocation(reqData);	//검색한 배드민턴장 갯수를 검색한다.
		} else {	//장소명을 검색해 배드민턴장 목록 검색하기
			reqData = new CourtReqDTO(name, pageNo);
			courts = courtService.getCourtListByName(reqData);	//검색 조건에 맞는 배드민턴장 목록을 조회한다.
			cnt = courtService.getCourtCntByName(name);	//검색한 배드민턴장 갯수를 검색한다.
		}
		
		if (courts.size()==0) {	
			//검색 결과 해당 위치에 존재하는 배드민턴 장소가 없다면 204 Status Code 전달
			return ResponseEntity.noContent().build();
		} else {
			//전달할 데이터를 저장하는 클래스(전체 데이터 수, 현재 페이지 번호, 배드민턴장 목록)
			CourtResDTO res = new CourtResDTO(cnt, pageNo, courts);
			
			return ResponseEntity.ok(res);
		}
	}
	
	//배드민턴장 id를 가지고 배드민턴장 상세정보 조회하기
	@GetMapping("/{id}")
	ResponseEntity<CourtDTO> getCourtById(@PathVariable Long id) {
		CourtDTO court = courtService.getCourtById(id);
		
		if (court==null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(court);
		}
	}
}
