package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;

public class GoodsDAO {

	
	// 상품 목록화(카테고리별)
	public List<GoodsDTO> goodsList(SqlSession session, String gCategory){
		return session.selectList("GoodsMapper.goodsList", gCategory);
	}
	
}
