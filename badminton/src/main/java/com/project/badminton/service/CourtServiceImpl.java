package com.project.badminton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;
import com.project.badminton.mapper.CourtMapper;

@Service
public class CourtServiceImpl implements CourtService {
	
	@Autowired 
	private CourtMapper courtMapper;

	//위치를 검색하여 배드민턴장 목록 조회하기
	@Override
	public List<CourtDTO> getCourtListByLocation(CourtReqDTO courtReqDTO) {
		return courtMapper.selectCourtListByLocation(courtReqDTO);
	}

	//장소명을 검색하며 배드민턴장 목록 조회하기
	@Override
	public List<CourtDTO> getCourtListByName(CourtReqDTO courtReqDTO) {
		return courtMapper.selectCourtListByName(courtReqDTO);
	}

	//배드민턴장 id를 검색해 배드민턴장 상세정보 조회하기
	@Override
	public CourtDTO getCourtById(Long courtId) {
		return courtMapper.selectCourtById(courtId);
	}

	//위치를 검색해 배드민턴장 전체 개수 조회하기
	@Override
	public int getCourtCntByLocation(CourtReqDTO courtReqDTO) {
		return courtMapper.selectTotalCourtCntByLocation(courtReqDTO);
	}

	//장소명을 검색하며 배트민턴장 전체 개수 조회하기
	@Override
	public int getCourtCntByName(String name) {
		return courtMapper.selectTotalCourtCntByName(name);
	}

}
