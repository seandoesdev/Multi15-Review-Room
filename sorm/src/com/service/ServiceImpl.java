package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MainDAO;
import com.dto.ClientDTO;
import com.dto.ManagerDTO;
import com.dto.PlaceDTO;
import com.dto.ReservationDTO;

public class ServiceImpl implements Service {

	public ClientDTO clientSignIn(HashMap<String, String> map){

		ClientDTO dbAccountDTO = null;
		SqlSession session = MySqlSessionFactory.getSession();

		try {
			MainDAO dao = new MainDAO();
			dbAccountDTO = dao.clientSignIn(session, map);

		} finally {
			session.close();
		}

		return dbAccountDTO;
	}

	public ManagerDTO managerSignIn(HashMap<String, String> map){

		ManagerDTO dbAccountDTO = null;
		SqlSession session = MySqlSessionFactory.getSession();

		try {
			MainDAO dao = new MainDAO();
			dbAccountDTO = dao.managerSignIn(session, map);

		} finally {
			session.close();
		}

		return dbAccountDTO;
	}

	public void clientSignUp(HashMap<String, String> map) throws Exception {

		SqlSession session = MySqlSessionFactory.getSession();

		try {
			MainDAO dao = new MainDAO();
			dao.clientSignUp(session, map);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void managerSignUp(HashMap<String, String> map) throws Exception {

		SqlSession session = MySqlSessionFactory.getSession();

		try {
			MainDAO dao = new MainDAO();
			dao.clientSignUp(session, map);
			session.commit();
		} finally {
			session.close();
		}
	}

	public List<PlaceDTO> selectPlaceALL() throws Exception {

		SqlSession session = MySqlSessionFactory.getSession();
		List<PlaceDTO> list = null;

		try {
			MainDAO dao = new MainDAO();
			list = dao.selectPlaceALL(session);
		} finally {
			session.close();
		}

		return list;
	}

	public List<ReservationDTO> selectResByNo(int num) throws Exception {

		SqlSession session = MySqlSessionFactory.getSession();
		List<ReservationDTO> list = null;

		try {
			MainDAO dao = new MainDAO();
			list = dao.selectResByNo(session, num);
		} finally {
			session.close();
		}

		return list;
	}

	public List<ReservationDTO> selectResDate() throws Exception {

		SqlSession session = MySqlSessionFactory.getSession();
		List<ReservationDTO> list = null;

		try {
			MainDAO dao = new MainDAO();
			list = dao.selectResDate(session);
		} finally {
			session.close();
		}

		return list;
	}

	public void insertResAll(ReservationDTO dto) throws Exception {
		SqlSession session = MySqlSessionFactory.getSession();
		
		try {
			MainDAO dao = new MainDAO();
			dao.insertResAll(session, dto);
			
		} finally {
			session.close();
		}
		
	}

	public List<ReservationDTO> selectResByCno(int num){
		SqlSession session = MySqlSessionFactory.getSession();
		List<ReservationDTO> list = null;

		try {
			MainDAO dao = new MainDAO();
			list = dao.selectResByCno(session, num);
		} finally {
			session.close();
		}

		return list;
	}
	
	
	public void deleteResAll(int num) throws Exception {
		SqlSession session = MySqlSessionFactory.getSession();

		try {
			MainDAO dao = new MainDAO();
			dao.deleteResAll(session, num);
		} finally {
			session.close();
		}
	}
	
	public void updateResDate(HashMap map) throws Exception {
		SqlSession session = MySqlSessionFactory.getSession();

		try {
			MainDAO dao = new MainDAO();
			dao.updateResDate(session, map);
		} finally {
			session.close();
		}
	}
	
	// manager
	
	public List<PlaceDTO> selectPlaceByMno(int num){
		SqlSession session = MySqlSessionFactory.getSession();
		List<PlaceDTO> list = null;

		try {
			MainDAO dao = new MainDAO();
			list = dao.selectPlaceByMno(session, num);
		} finally {
			session.close();
		}

		return list;
	}
}
