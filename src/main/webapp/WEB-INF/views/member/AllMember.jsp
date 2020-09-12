<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>모든 멤버</h1>
<hr>
<table border="1">
	<thead>
		<th>회원번호</th>
		<th>아이디</th>
		<th>이름</th>
	</thead>
	<tbody>
	<c:forEach items="${AllMember }" var="member">
		<tr>
			<td>${member.member_no }</td>
			<td>${member.id }</td>
			<td>${member.name }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<br>
<hr>
<a href="/main">메인화면</a>
<a href="/member/insertMemberForm">회원가입</a>
<a href="/board/AllBoard">게시판</a>
</body>
</html>