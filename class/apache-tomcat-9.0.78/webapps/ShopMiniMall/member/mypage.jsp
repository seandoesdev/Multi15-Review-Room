<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

아이디: ${login.userid}<br>
이름: ${login.username}<br>

<form action="">
	<!-- kakao address API -->
	<input type="text" name="post" id="sample4_postcode" placeholder="우편번호">
	<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
	<input type="text" name="addr1" id="sample4_roadAddress" placeholder="도로명주소">
	<input type="text" name="addr2" id="sample4_jibunAddress" placeholder="지번주소">
	<span id="guide" style="color:#999"></span>
	<br>
	<!-- kakao address API -->
	
	전화번호:
	<select name="phone1">
	 <option value="010">010</option>
	 <option value="011">011</option>
	</select>-
	<input type="text" name="phone2">-
	<input type="text" name="phone3"><br>
	이메일:
	<input type="text" name="email1">@<input type="text" name="email2" placeholder="직접입력">
	<select>
	 <option value="daum.net">daum.net</option>
	 <option value="google.com">google.com</option>
	 <option value="naver.com">naver.com</option>
	</select>
	<br>
	<input type="submit" value="수정">
	<input type="reset" value="취소">

</form>

