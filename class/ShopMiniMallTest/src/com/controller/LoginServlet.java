package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userid", request.getParameter("userid"));
		map.put("passwd", request.getParameter("passwd"));
		
		MemberDTO dto = new MemberDTO();
		MemberService service = new MemberServiceImpl();
		dto = service.login(map);
		
		String nextPage = "";
		if (dto != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", dto);
			
			nextPage="main";
			
		} else 
			nextPage = "member/loginFail.jsp";
		
		response.sendRedirect(nextPage);
	}

}
