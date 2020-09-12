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
<h1>게시판</h1>
<hr>
<form action="#" >
	<section>
		<option>자유게시판</option>
		<option>질문</option>
		<option>유머</option>
	</section>
</form>
<table border="1">
	<thead>
		<tr>
			<th>카테고리</th>
			<th>게시물 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${AllBoard }" var="board">
			<tr onclick="window.location.href='/board/detailBoard?board_no=${board.board_no}'">
				<td>${board.category }</td>
				<td>${board.board_no }</td>
				<td>${board.title } [${board.cnt }]</td>
				<td>${board.id }</td>
				<td>${board.hit }</td>
				<td>${board.board_date }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<c:choose>
 <c:when test="${empty loginid }">
 	<a href="/loginForm?url=/board/AllBoard">로그인</a>
 	<a href="/member/insertMemberForm">회원가입</a>
 </c:when>
 <c:otherwise>
 	<a href="/logout">로그아웃</a>
 	<a href="/board/insertBoardForm">게시물 작성</a>
 </c:otherwise>
</c:choose>
<a href="/main">메인화면으로 이동</a>

</body>
</html>