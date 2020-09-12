<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 작성</h1>
<hr>
<form action="/board/insertBoard" method="post" enctype="Multipart/form-data">
	<select name="category">
		<option value="자유게시판">자유게시판</option>
		<option value="질문">질문</option>
		<option value="유머">유머</option>
	</select>
	<label for="id"></label>
	<input type="text" id="id" name="id" value="${loginid }" readonly="readonly"><br>
	<label for="title"></label>
	<input type="text" id="title" name="title" required="required"><br>
	<textarea rows="10" cols="100" name="content"></textarea><br>
	<label for="mf">업로드 파일</label><br>
	<input type="file" id="mf" name="mf"><br>
	<button type="submit">등록</button>
</form>
<br>
<a href="/main">메인으로 이동</a>
<a href="/board/AllBoard">게시판</a>
</body>
</html>