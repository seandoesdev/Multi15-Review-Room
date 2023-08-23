package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ClientDTO;
import com.dto.ManagerDTO;
import com.dto.PlaceDTO;
import com.dto.ReservationDTO;

public class MainDAO {
	
	// signIn
	public ClientDTO clientSignIn(SqlSession session, HashMap<String, String> map){

		ClientDTO dbAccountDTO = session.selectOne("Mapper.clientSignIn", map);

		return dbAccountDTO;
	}
	
	public ManagerDTO managerSignIn(SqlSession session, HashMap<String, String> map){

		ManagerDTO dbAccountDTO = session.selectOne("Mapper.managerSignIn", map);

		return dbAccountDTO;
	}
	
	// signUp 
	public void clientSignUp(SqlSession session, HashMap<String, String> map) throws Exception {

		session.insert("Mapper.clientSignUp", map);

	}
	
	public void managerSignUp(SqlSession session, HashMap<String, String> map) throws Exception {

		session.insert("Mapper.managerSignUp", map);
	}
	
	
	public List<PlaceDTO> selectPlaceALL(SqlSession session) throws Exception {
		
		List<PlaceDTO> list = session.selectList("Mapper.selectPlaceALL");
		
		return list;
	}
	
	public List<ReservationDTO> selectResByNo(SqlSession session, int num) throws Exception {
		
		List<ReservationDTO> list = session.selectList("Mapper.selectResByNo", num);

		return list;
	}
	
	public List<ReservationDTO> selectResDate(SqlSession session) throws Exception {
		
		List<ReservationDTO> list = session.selectList("Mapper.selectResDate");
		
		return list;
	}

	public void insertResAll(SqlSession session, ReservationDTO dto) throws Exception {
		
		session.insert("Mapper.insertResAll",dto);
	}
	
	public List<ReservationDTO> selectResByCno(SqlSession session, int num){
		
		List<ReservationDTO> list = session.selectList("Mapper.selectResByCno", num);
		
		return list;
	}
	
	public void deleteResAll(SqlSession session, int num) throws Exception {
		
		session.delete("Mapper.deleteResAll", num);
	}
	
	public void updateResDate(SqlSession session, HashMap map) throws Exception {
		session.update("Mapper.updateResDate", map);
	}
	
	// manager
	public List<PlaceDTO> selectPlaceByMno(SqlSession session, int num){
		
		List<PlaceDTO> list = session.selectList("Mapper.selectPlaceByMno", num);
		
		return list;
	}
}
