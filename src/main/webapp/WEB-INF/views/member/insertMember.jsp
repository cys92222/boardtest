<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){


	$("#chk_id").click(function(){
		var in_id = $("#id").val();

		var data = {
					"in_id" : in_id
				}
		$.ajax("/member/checkId",{data:data,success:function(re){
			alert(re);
			}});
		});
})
	

</script>
<body>
<h1>회원가입</h1>
<hr>
<form action="/member/insertMember" method="post">
	<label for="id">아이디</label>
	<input type="text" id="id" name="id" minlength="4" maxlength="12" required="required" placeholder="4글자 이상 12글자 이하">
	<button type="button" id="chk_id">중복확인</button><br>
	<label for="pwd">암호</label>
	<input type="password" id="pwd" name="pwd" minlegth="6" maxlength="12" required="required"><br>
	<label for="name">이름</label>
	<input type="text" id="name" name="name" minlegth="3" maxlength="12" required="required"><br>
	
	<button type="submit">가입</button>
	<a href="/main">메인으로 돌아가기</a>
</form>
</body>
</html>