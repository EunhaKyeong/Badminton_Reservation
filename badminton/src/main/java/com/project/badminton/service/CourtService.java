package com.project.badminton.service;

import java.util.List;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;

public interface CourtService {
	List<CourtDTO> getCourtListByLocation(CourtReqDTO courtReqDTO);	//위치를 검색하여 배드민턴장 목록 조회하기
	List<CourtDTO> getCourtListByName(CourtReqDTO courtReqDTO);	//장소명을 검색하며 배트민턴장 목록 조회하기
	CourtDTO getCourtById(Long courtId);	//배드민턴장 id를 검색해 배드민턴장 상세정보 조회하기
	int getCourtCntByLocation(CourtReqDTO courtReqDTO);	//위치를 검색해 배드민턴장 전체 개수 조회하기
	int getCourtCntByName(String name);	//장소명을 검색하며 배트민턴장 전체 개수 조회하기
}
