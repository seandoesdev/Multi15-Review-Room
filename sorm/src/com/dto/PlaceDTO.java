package com.dto;

public class PlaceDTO {

	private int place_no;
	private int mangaerNo;
	private String place_nm;
	private String place_ard;

	public PlaceDTO() {
	}
	


	public PlaceDTO(int place_no, String place_nm) {
		this.place_no = place_no;
		this.place_nm = place_nm;
	}



	public PlaceDTO(int place_no, int mangaerNo,
		String place_nm, String place_ard) {
		this.place_no = place_no;
		this.mangaerNo = mangaerNo;
		this.place_nm = place_nm;
		this.place_ard = place_ard;
	}
	

	public int getplace_no() {
		return place_no;
	}


	public int getMangaerNo() {
		return mangaerNo;
	}


	public String getplace_nm() {
		return place_nm;
	}


	public String getplace_ard() {
		return place_ard;
	}


	@Override
	public String toString() {
		return "placeDTO{" +
			"place_no=" + place_no +
			", mangaerNo=" + mangaerNo +
			", palceNm='" + place_nm + '\'' +
			", place_ard='" + place_ard + '\'' +
			'}';
	}
}
