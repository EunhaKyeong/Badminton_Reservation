package com.project.badminton.domain;

import com.project.badminton.paging.Criteria;

//CourtMapper.java에서 selectCourtList 메서드 호출 시 사용되는 request 객체
//페이징처리를 위한 Criteria 클래스를 상속받는다.
public class CourtReqDTO extends Criteria {
	
	private String metropolitanCity;
	private String sigungu;
	private String eupmyeonri;
	private String name;
	
	public CourtReqDTO(String metropolitanCity, String sigungu, String eupmyeonri, int pageNo) {
		super();
		this.metropolitanCity = metropolitanCity;
		this.sigungu = sigungu;
		this.eupmyeonri = eupmyeonri;
		this.setCurrentPageNo(pageNo);
	}
	
	public CourtReqDTO(String name, int pageNo) {
		super();
		this.name = name;
		this.setCurrentPageNo(pageNo);
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CourtReqDTO [metropolitanCity=" + metropolitanCity + ", sigungu=" + sigungu + ", eupmyeonri="
				+ eupmyeonri + ", name=" + name + "]";
	}
	
}
