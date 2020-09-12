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

// 	파일 첨부 미리보기
// 	var test = $("#mf")[0];
// 	test.onchange = function(e){
// 		var change = test.files[0];
// 		console.log(change.name);
// // 		$("#image2").attr("src",change.name);
// 		$("#image2").attr("src",change.);

	
	$("#delete_btn").click(function(){
// 		alert("업로드한 파일을 삭제했습니다");
		$("#filename").val("");
		$("#image").attr("src","");
		});
	
});
</script>
<body>
<h1>게시물 수정</h1>
<hr>
<form action="/board/updateBoard" method="post" enctype="Multipart/form-data">
	<input type="hidden" name="board_no" value="${detail.board_no }">
	<input type="hidden" id="filename" name="filename" value="${detail.filename }">
	<input type="hidden" id="oldfilename" name="oldfilename" value="${detail.filename }">

	<select name="category">
		<option value="자유게시판">자유게시판</option>
		<option value="질문">질문</option>
		<option value="유머">유머</option>
	</select>
	<label for="id"></label>
	<input type="text" id="id" name="id" value="${loginid }" readonly="readonly"><br>
	<label for="title"></label>
	<input type="text" id="title" name="title" value="${detail.title }" required="required"><br>
	<c:if test="${!empty detail.filename }">
		<img alt="" src="/file/img/${detail.filename }" id="image"><br>
		<button type="button" id="delete_btn" onclick="return confirm('업로드한 파일을 삭제하시겠습니까?')">업로드 파일 삭제</button><br>
	</c:if>
	<textarea rows="10" cols="100" name="content">${detail.content }</textarea><br>
	<label for="mf">업로드 파일 수정</label><br>
	<input type="file" id="mf" name="mf"><br>
	<button type="submit">수정하기</button>
</form>
<a href="/board/detailBoard?board_no=${detail.board_no }">취소</a>
</body>
</html>