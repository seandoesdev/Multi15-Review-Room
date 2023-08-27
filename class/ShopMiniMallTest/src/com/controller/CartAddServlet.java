package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.CartDTO;
import com.dto.MemberDTO;
import com.service.CartService;
import com.service.CartServiceImpl;


@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		// 로그인 여부 확인
		if (memberDTO != null) {
			String userid = memberDTO.getUserid();
			String gCode = request.getParameter("gCode");
			String gName = request.getParameter("gName");
			String gPrice = request.getParameter("gPrice");
			String gSize = request.getParameter("gSize");
			String gColor = request.getParameter("gColor");
			String gAmount = request.getParameter("gAmount");
			String gImage = request.getParameter("gImage");
			
			CartDTO cartDTO = new CartDTO(0, userid, gCode, gName, gPrice, gSize, gColor,
					gAmount, gImage);
			
			CartService service = new CartServiceImpl();
		    int n = service.cartAdd(cartDTO);
		    nextPage="goods/cartAddSuccess.jsp";
		    
		} else {
			nextPage = "member/checkLogin.jsp";
		}
		
		response.sendRedirect(nextPage);
		
		
		
		
	}
}
