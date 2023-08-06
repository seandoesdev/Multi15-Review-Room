package com.sorm.DTO;

public class managerDTO {

	private int managerNo;
	private String managerId;
	private String managerPw;
	private String phone;

	public managerDTO() {
	}

	public managerDTO(int managerNo, String managerId,
		String managerPw, String phone) {
		this.managerNo = managerNo;
		this.managerId = managerId;
		this.managerPw = managerPw;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "managerDTO{" +
			"managerNo=" + managerNo +
			", managerId='" + managerId + '\'' +
			", managerPw='" + managerPw + '\'' +
			", phone='" + phone + '\'' +
			'}';
	}
}
