package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;
import com.service.MemberServiceImpl;

@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO)session.getAttribute("login");
		
		String nextPage = "";
		if(dto != null) {
			
			nextPage = "mypage.jsp";
			// 세션에 필요한 데이터가 전부 없을 수 있으니 DB에서 가져온다.???
			
			String userid = dto.getUserid();
			MemberDTO mypage = new MemberDTO();
			MemberService service = new MemberServiceImpl();
			
			mypage = service.myPage(userid);
			session.setAttribute("login", mypage);
			
		} else
			nextPage = "member/checklogin.jsp";
		
		
		response.sendRedirect(nextPage);
	}

}
