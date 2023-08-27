package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;

public class CartDAO {

	
	public int cartAdd(SqlSession session, CartDTO cartDTO) {
		return session.insert("CartMapper.cartAdd", cartDTO);
	}
	
	public List<CartDTO> cartList(SqlSession session, String userid){
		return session.selectList("CartMapper.cartList", userid);
	}
	
}
