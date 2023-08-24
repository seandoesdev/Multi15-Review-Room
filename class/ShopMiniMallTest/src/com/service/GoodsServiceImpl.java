package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.GoodsDAO;
import com.dto.GoodsDTO;

public class GoodsServiceImpl implements GoodsService {

	public List<GoodsDTO> goodsList(String gCategory){
		
		try (SqlSession session = MySqlSessionFactory.getSession()){
			GoodsDAO dao = new GoodsDAO();
			return dao.goodsList(session, gCategory);
		}
	}

}

/*
       try (SqlSession session = MySqlSessionFactory.getSession()){
			GoodsDAO dao = new GoodsDAO();
			return 
		}


*/
