package com.project.badminton.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.badminton.domain.CourtDTO;
import com.project.badminton.domain.CourtReqDTO;

@Mapper
public interface CourtMapper {
	//클라이언트가 입력한 지역정보(광역시도, 시군구, 읍면동리)에 위치하는 배드민턴장 데이터를 court 테이블에서 select 한다.
	List<CourtDTO> selectCourtListByLocation(CourtReqDTO courtReqDTO);
	//클라이언트가 검색한 장소명이 포함되는 배드민턴장 데이터를 court 테이블에서 select 한다.
	List<CourtDTO> selectCourtListByName(String name);
}
