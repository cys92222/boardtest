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
<h1>게시물 상세보기</h1>
<hr>

<c:if test="${loginid eq detail.id }">
	<a href="/board/deleteBoard?board_no=${detail.board_no }&filename=${detail.filename}" onclick="return confirm('게시물을 삭제할까요 ?')">삭제</a>
	<a href="/board/updateBoardForm?board_no=${detail.board_no }" onclick="return confirm('게시물을 수정할까요 ?')">수정</a>
</c:if>

<table>
	<tr>
		<td>카테고리</td>
		<td>${detail.category }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${detail.title }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${detail.id }</td>
	</tr>
	<tr>
		<td>작성일</td>
		<td>${detail.board_date }</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>조회수${detail.hit }</td>
	</tr>
</table>
<br>
<c:if test="${!empty detail.filename}">
	<img alt="업로드 파일" src="/file/img/${detail.filename }"><br>
</c:if>
<textarea readonly="readonly">${detail.content }</textarea>
<br>
<hr>
<br>
<h3>댓글 입력</h3>
<c:choose>
 	<c:when test="${empty loginid }">
 		<p>로그인해야 댓글을 작성할 수 있습니다</p>
 	</c:when>
 	<c:otherwise>
 		<form action="/board/insertBoardComment" method="post">
 			<input type="hidden" value="${detail.board_no }" name="board_no">
			<label for="id">작성자</label>
			<input type="text" id="id" name="id" readonly="readonly" value="${loginid }"><br>
			<label for="content">내용</label>
			<input type="text" id="content" name="content"><br>
			<button type="submit">댓글 등록</button>
		</form>
 	</c:otherwise>
</c:choose>

<br>
<hr>
<h3>댓글 목록</h3>
<table>
<tr>
	<td>작성자</td>
	<td>내용</td>
	<td>작성일</td>
	<td></td>
</tr>
<c:forEach items="${comment }" var="comment">
	<tr>
		<td>${comment.id }</td>
		<td>${comment.content }</td>
		<td>${comment.comment_date }</td>
		<c:choose>
			<c:when test="${empty loginid }">
				<td></td>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${comment.id eq loginid }">
						<td><a href="/board/deleteComment?comment_no=${comment.comment_no }">삭제</a></td>
					</c:when>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</tr>
</c:forEach>
</table>
<br>
<a href="/main">메인으로 이동</a>
<a href="/board/AllBoard">게시판</a>
<c:choose>
 <c:when test="${empty loginid }">
 	<a href="/loginForm?url=/board/detailBoard?board_no=${detail.board_no }">로그인</a>
 	<a href="/member/insertMemberForm">회원가입</a>
 </c:when>
 <c:otherwise>
 	<a href="/logout">로그아웃</a>
 </c:otherwise>
</c:choose>
</body>
</html>