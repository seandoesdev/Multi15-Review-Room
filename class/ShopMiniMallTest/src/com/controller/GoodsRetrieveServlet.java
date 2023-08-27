package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.GoodsDTO;
import com.service.GoodsService;
import com.service.GoodsServiceImpl;


@WebServlet("/GoodsRetrieveServlet")
public class GoodsRetrieveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String gCode = request.getParameter("gCode");
		
		GoodsService service = new GoodsServiceImpl();
		GoodsDTO dto = service.goodsRetrieve(gCode);
		
		request.setAttribute("goodsRetrieve", dto);
		
		request.getRequestDispatcher("goodsRetrieve.jsp").forward(request, response);
	}

}
