package com.controller;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = null;
		if (dto != null) {
			
			String userid = dto.getUserid();
			CartService service = new CartServiceImpl();
			List<CartDTO> list = service.cartList(userid); 
			
			session.setAttribute("cartList", list);
			
			nextPage="cartList.jsp";
		} else {
			nextPage ="member/checkLogin.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
