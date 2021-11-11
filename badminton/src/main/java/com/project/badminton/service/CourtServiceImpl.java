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
	public List<CourtDTO> getCourtListByName(String name) {
		return courtMapper.selectCourtListByName(name);
	}

}
