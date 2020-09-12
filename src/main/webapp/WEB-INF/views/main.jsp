<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
});
</script>
</head>
<body>
<h1>메인화면</h1>
<hr>
<c:choose>
 <c:when test="${empty loginid }">
 	<a href="/loginForm?url=/main">로그인</a>
 	<a href="/member/insertMemberForm">회원가입</a>
 </c:when>
 <c:otherwise>
 	<a href="/logout">로그아웃</a>
<!--  	<script type="text/javascript"> -->
<%-- 		alert("${loginid} 환영합니다") --%>
<!--  	</script> -->

 </c:otherwise>
</c:choose>
<a href="/board/AllBoard">게시판</a>

</body>
</html>