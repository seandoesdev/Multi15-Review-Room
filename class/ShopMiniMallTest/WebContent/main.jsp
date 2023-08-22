<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인홈페이지</title>
</head>
<body>
<h2>Main 화면입니다.</h2>
<jsp:include page="common/top.jsp" flush="false"></jsp:include><br>
<jsp:include page="common/menu.jsp" flush="false"></jsp:include>
<hr>
<jsp:include page="goods/goodsList.jsp" flush="flase"/>
</body>
</html>