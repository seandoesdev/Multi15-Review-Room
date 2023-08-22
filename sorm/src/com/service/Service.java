package com.service;



import java.util.HashMap;
import java.util.List;

import com.dto.ClientDTO;
import com.dto.ManagerDTO;
import com.dto.PlaceDTO;
import com.dto.ReservationDTO;

public interface Service {
	
	public ClientDTO clientSignIn(HashMap<String, String> map);
	public ManagerDTO managerSignIn(HashMap<String, String> map);
	public void clientSignUp(HashMap<String, String> map) throws Exception;
	public void managerSignUp(HashMap<String, String> map) throws Exception;
	
	public List<PlaceDTO> selectPlaceALL() throws Exception;
	public List<ReservationDTO> selectResByNo(int num) throws Exception;
	public List<ReservationDTO> selectResDate() throws Exception;
	public void insertResAll(ReservationDTO dto) throws Exception;
	public List<ReservationDTO> selectResByCno(int num);
	public void deleteResAll(int num) throws Exception;
	public void updateResDate(HashMap map) throws Exception;
	
	// manager
	public List<PlaceDTO> selectPlaceByMno(int num);
}
