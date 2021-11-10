package com.project.badminton.domain;

//CourtMapper.java에서 selectCourtList 메서드 호출 시 사용되는 request 객체
public class CourtReqDTO {
	
	private String metropolitanCity;
	private String sigungu;
	private String eupmyeonri;
	
	public CourtReqDTO() {
		
	}
	
	public CourtReqDTO(String metropolitanCity, String sigungu, String eupmyeonri) {
		super();
		this.metropolitanCity = metropolitanCity;
		this.sigungu = sigungu;
		this.eupmyeonri = eupmyeonri;
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
	
	@Override
	public String toString() {
		return "CourtRequestDTO [metropolitanCity=" + metropolitanCity + ", sigungu=" + sigungu + ", eupmyeonri="
				+ eupmyeonri + "]";
	}
}
