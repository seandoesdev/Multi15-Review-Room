package com.sorm.DTO;

import java.util.Objects;

public class clientDTO {

	private int clientNo;
	private String clientId;
	private String clientPw;
	private String clientNm;
	private String phone;
	private String secessionFl;

	public clientDTO() {
	}

	public clientDTO(int clientNo, String clientId, String clientPw, String clientNm, String phone,
		String secessionFl) {
		this.clientNo = clientNo;
		this.clientId = clientId;
		this.clientPw = clientPw;
		this.clientNm = clientNm;
		this.phone = phone;
		this.secessionFl = secessionFl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		clientDTO clientDTO = (clientDTO)o;
		return clientNo == clientDTO.clientNo && Objects.equals(clientId, clientDTO.clientId)
			&& Objects.equals(clientPw, clientDTO.clientPw) && Objects.equals(clientNm,
			clientDTO.clientNm) && Objects.equals(phone, clientDTO.phone) && Objects.equals(secessionFl,
			clientDTO.secessionFl);
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientNo, clientId, clientPw, clientNm, phone, secessionFl);
	}

	@Override
	public String toString() {
		return "clientDTO{" +
			"clientNo=" + clientNo +
			", clientId='" + clientId + '\'' +
			", clientPw='" + clientPw + '\'' +
			", clientNm='" + clientNm + '\'' +
			", phone='" + phone + '\'' +
			", secessionFl='" + secessionFl + '\'' +
			'}';
	}
}
