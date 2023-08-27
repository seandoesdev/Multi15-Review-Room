package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public interface CartService {

	public int cartAdd(CartDTO cartDTO);
	public List<CartDTO> cartList(String userid);
}
