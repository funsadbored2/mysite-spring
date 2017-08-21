<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath }/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<title>ajax-mysite</title>
</head>
<body>

	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="wrapper">
			<div id="content">
				<div id="guestbook">

					<form id = "write-form" action="${pageContext.request.contextPath }/api/guestbook/add"
						method="post">
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" id ="name" name="name" /></td>
								<td>비밀번호</td>
								<td><input type="password" id ="ps" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea id="content" name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 " /></td>
							</tr>
						</table>
					</form>
					
				<!-- 리스트 뿌려지는 부분 -->
				<ul id = "guestbook-list">

				</ul>
				</div>
				<!-- /guestbook -->
			</div>
			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>
	<!-- /container -->

</body>

<script type="text/javascript">
	
	$(document).ready(function(){
		//리스트 출력
		fetchList();
		
		//저장버튼 출력
		$("#write-form").on("submit",function(){
			event.preventDefault();
			console.log("전송 성공함");
			
			var guetbookInfo = {
					name : $("[name = name]").val(),
					password : $("[name=password]").val(),
					content : $("[name=content]").val()
			}
			
			
			$.ajax({

				url : "${pageContext.request.contextPath }/api/guestbook/add",
				type : "post",
				contentType : "application/json",
				data : JSON.stringify(guetbookInfo),

				dataType : "json", 
				success : function(guestbookVo){
						console.log(guestbookVo);
						render(guestbookVo, "up");
				},	
				
				error : function(XHR, status, error) {
				console.error(status + " : " + error);
				}
				});
						
		});
		
	});
	
	function fetchList(){
		
		$.ajax({

			url : "${pageContext.request.contextPath }/api/guestbook/list",
			type : "post",
			//contentType : "application/json",
			//data : {name: ”홍길동"},

			dataType : "json",
			success : function(gbList){
				
				for(var i = 0; i < gbList.length; i++){
					
					render(gbList[i], "down");
					
				}
				console.log(gbList);
				/*성공시 처리해야될 코드 작성*/
			},	
			
			error : function(XHR, status, error) {
			console.error(status + " : " + error);
			}
			});
		
	}
	
	function render(GuestbookVo, updown) {
		
		var str = " ";
		str += "<li>";
		str += "	<table>";
		str += "           <tr>";
		str += "               <td>[" + GuestbookVo.no + "] </td>";
		str += "               <td>" + GuestbookVo.name + "</td>";
		str += "               <td>[" + GuestbookVo.regDate + "]  </td>";
		str += "               <td><a href='#'>삭제</a></td>";
		str += "           </tr>";
		str += "           <tr>";
		str += "               <td colspan=4>" + GuestbookVo.content + "  </td>";
		str += "           </tr>";
		str += "	</table>";
		str += "	<br/>";  
		str += "</li>";
		
		if(updown == "down"){
		$("#guestbook-list").append(str);
		} else if(updown = "up"){
		$("#guestbook-list").prepend(str);
		}else {$("#guestbook-list").append(str);}
	}
		
		
	
	
</script>

</html>