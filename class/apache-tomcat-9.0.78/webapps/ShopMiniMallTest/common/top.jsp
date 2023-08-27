<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:if test="${empty login}">
	<a href="<c:url value='LoginUIServlet'/>">로그인</a>
	<a href="<c:url value='MemberUIServlet'/>">회원가입</a>
</c:if>

<c:if test="${!empty login }">
	안녕하세요. ${login.username}
	<a href="<c:url value='LogOutServlet'/>">로그아웃</a>
	<a href="<c:url value='MyPageServlet' />">MyPage</a>
	<a href="<c:url value='' />">장바구니목록</a>
</c:if>

