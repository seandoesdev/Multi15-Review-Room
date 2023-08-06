package com.sorm.DTO;

public class placeDTO {

	private int placeNo;
	private int mangaerNo;
	private String placeNm;
	private String placeARD;

	public placeDTO() {
	}
	
	

	public placeDTO(int placeNo, String placeNm) {
		this.placeNo = placeNo;
		this.placeNm = placeNm;
	}



	public placeDTO(int placeNo, int mangaerNo,
		String placeNm, String placeARD) {
		this.placeNo = placeNo;
		this.mangaerNo = mangaerNo;
		this.placeNm = placeNm;
		this.placeARD = placeARD;
	}
	
	

	public int getPlaceNo() {
		return placeNo;
	}


	public int getMangaerNo() {
		return mangaerNo;
	}


	public String getPlaceNm() {
		return placeNm;
	}


	public String getPlaceARD() {
		return placeARD;
	}


	@Override
	public String toString() {
		return "placeDTO{" +
			"placeNo=" + placeNo +
			", mangaerNo=" + mangaerNo +
			", palceNm='" + placeNm + '\'' +
			", placeARD='" + placeARD + '\'' +
			'}';
	}
}
