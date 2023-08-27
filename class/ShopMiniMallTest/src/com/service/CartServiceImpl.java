package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.CartDAO;
import com.dto.CartDTO;

public class CartServiceImpl implements CartService {

	public int cartAdd(CartDTO cartDTO) {
		
		try (SqlSession session = MySqlSessionFactory.getSession()){
			CartDAO dao = new CartDAO();
			return dao.cartAdd(session, cartDTO);
		}
	}
	
	public List<CartDTO> cartList(String userid){
		 try (SqlSession session = MySqlSessionFactory.getSession()){
				CartDAO dao = new CartDAO();
				return dao.cartList(session, userid);
			}
	}

}

/*
       try (SqlSession session = MySqlSessionFactory.getSession()){
			GoodsDAO dao = new GoodsDAO();
			return 
		}


*/
