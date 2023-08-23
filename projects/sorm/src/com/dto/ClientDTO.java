package com.dto;



public class ClientDTO {

	private int client_no;
	private String client_id;
	private String client_pw;
	private String client_nm;
	private String phone;
	private String secession_fl;

	public ClientDTO() {
	}

	public ClientDTO(int client_no, String client_id, String client_pw, String client_nm, String phone,
			String secession_fl) {
		this.client_no = client_no;
		this.client_id = client_id;
		this.client_pw = client_pw;
		this.client_nm = client_nm;
		this.phone = phone;
		this.secession_fl = secession_fl;
	}

	public int getClient_no() {
		return client_no;
	}

	public void setClient_no(int client_no) {
		this.client_no = client_no;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_pw() {
		return client_pw;
	}

	public void setClient_pw(String client_pw) {
		this.client_pw = client_pw;
	}

	public String getClient_nm() {
		return client_nm;
	}

	public void setClient_nm(String client_nm) {
		this.client_nm = client_nm;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSecession_fl() {
		return secession_fl;
	}

	public void setSecession_fl(String secession_fl) {
		this.secession_fl = secession_fl;
	}
	
	
	
}
