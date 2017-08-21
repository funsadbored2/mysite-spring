<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
	<title>Insert title here</title>
</head>
<body>

	<div id="container">
		
	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

	<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
	
		<div id="wrapper">
			<div id="content">
				<div id="user">
	
					<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
						
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value=""/>
	
						<label class="block-label" for="email">이메일</label>
						<input id="email" name="email" type="text" value=""/>
						<input id = "emailbtn" type="button" value="id 중복체크" >
						<p style="color:red" id = "validation"></p>
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value=""/>
						
						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="male">
						</fieldset>
						
						<fieldset>
							<legend>약관동의</legend>
							<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
							<label>서비스 약관에 동의합니다.</label>
						</fieldset>
						
						<input type="submit" value="가입하기">
						
					</form>
					
				</div><!-- /user -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div> <!-- /container -->

</body>
<script type="text/javascript">
	
	$(document).ready(function(){
	
	$("#emailbtn").on("click",function(){
		event.preventDefault();
		console.log("들어옴");
		var emailValidation = {
				email : $("[name = email]").val()
				}

		$.ajax({

			url : "${pageContext.request.contextPath}/user/emailcheck",
			type : "post",
			/* contentType : "application/json", */
			data : emailValidation,

			dataType : "json", 
			success : function(check){
					
					console.log(check);
					
					if(check == true){
						validate("이메일을 사용하실 수 있습니다.");
					}
					else if(check == false){
						validate("이 이메일은 사용중입니다.");
					}
				},	
			
				error : function(XHR, status, error) {
				console.error(status + " : " + error);
				}
			});
	
		});
		
	});
	
	function validate(str) {
		$("#validation").text(str);
	}

</script>
</html>