package com.dto;

public class ReservationDTO {
	
	private int res_no;
	private int place_no;
	private int client_no;
	private String end_use;
	private String res_date;
	
	
	
	public ReservationDTO() {
	}



	public ReservationDTO(String res_date) {
		this.res_date = res_date;
	}

	


	public ReservationDTO(int place_no, int client_no, String res_date) {
		this.place_no = place_no;
		this.client_no = client_no;
		this.res_date = res_date;
	}
	



	public ReservationDTO(int res_no, int place_no, int client_no, String end_use, String res_date) {
		this.res_no = res_no;
		this.place_no = place_no;
		this.client_no = client_no;
		this.end_use = end_use;
		this.res_date = res_date;
	}





	public int getRes_no() {
		return res_no;
	}



	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}



	public int getPlace_no() {
		return place_no;
	}



	public void setPlace_no(int place_no) {
		this.place_no = place_no;
	}



	public int getClient_no() {
		return client_no;
	}



	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}



	public String getEnd_use() {
		return end_use;
	}



	public void setEnd_use(String end_use) {
		this.end_use = end_use;
	}



	public String getRes_date() {
		return res_date;
	}



	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}



	@Override
	public String toString() {
		return "ReservationDTO [place_no=" + place_no + ", client_no=" + client_no + ", end_use=" + end_use
				+ ", res_date=" + res_date + "]";
	}
	
	
	
	
}

