package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.GoodsDTO;
import com.dto.MemberDTO;

public interface GoodsService {

	public List<GoodsDTO> goodsList(String gCategory);
}
