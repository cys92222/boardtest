<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#login_button").click(function(){
		var data = $("#form").serialize();
// 		console.log(data);
		$.ajax("/login",{data:data,success:function(r){
			if(r!=="아이디 암호를 확인하세요"){
<%-- 				<% String login = (String)session.getAttribute("loginid"); %> --%>
				var loginid = $("#id").val();
				
				alert( loginid + "님 환영합니다");
 				window.location.href = r;
				}else{
					alert(r);
					}

			}});
		});


})
</script>
<body>
<h1>로그인</h1>
<hr>
<form id="form">
	<input type="hidden" name="url" value="${url }">
	<label for="id">아이디</label>
	<input type="text" id="id" name="id"><br>
	<label for="pwd">암호</label>
	<input type="password" id="pwd" name="pwd"><br>
</form>


 <button type="button" id="login_button">로그인</button>


<a href="/main">메인으로 돌아가기</a>
<a href="/board/AllBoard">게시판</a>
</body>
</html>