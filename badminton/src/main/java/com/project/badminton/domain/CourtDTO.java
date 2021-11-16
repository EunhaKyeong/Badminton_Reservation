package com.project.badminton.domain;

import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonInclude;

//court 테이블 DTO
@JsonInclude(JsonInclude.Include.NON_NULL)	//JSON으로 클라이언트에게 데이터를 전달할 때 null인 필드는 제외하고 전달한다.
public class CourtDTO {
	private Long id;
	private String name;
	private String metropolitanCity;
	private String sigungu;
	private String eupmyeonri;
	private Time openTime;
	private Time closeTime;
	private String link;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMetropolitanCity() {
		return metropolitanCity;
	}
	public void setMetropolitanCity(String metropolitanCity) {
		this.metropolitanCity = metropolitanCity;
	}
	public String getSigungu() {
		return sigungu;
	}
	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}
	public String getEupmyeonri() {
		return eupmyeonri;
	}
	public void setEupmyeonri(String eupmyeonri) {
		this.eupmyeonri = eupmyeonri;
	}
	public Time getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Time openTime) {
		this.openTime = openTime;
	}
	public Time getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Time closeTime) {
		this.closeTime = closeTime;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "CourtDTO [id=" + id + ", name=" + name + ", metropolitanCity=" + metropolitanCity + ", sigungu="
				+ sigungu + ", eupmyeonri=" + eupmyeonri + ", openTime=" + openTime + ", closeTime=" + closeTime
				+ ", link=" + link + "]";
	}
}
