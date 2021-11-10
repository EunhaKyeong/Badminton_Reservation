package com.project.badminton.service;

import java.util.List;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;

public interface CourtService {
	List<CourtDTO> getCourtListByLocation(CourtReqDTO courtReqDTO);	//위치를 검색하여 배드민턴장 목록 조회하기

}
