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

					<form action="${pageContext.request.contextPath }/guestbook/add"
						method="post">
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name" /></td>
								<td>비밀번호</td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 " /></td>
							</tr>
						</table>
					</form>


					<c:forEach items="${list}" var="v">

						<ul>
							<li>
								<table>
									<tr>
										<td>[${v.no }]</td>
										<td>${v.name }</td>
										<td>${v.regDate }</td>
										<td><a
											href="${pageContext.request.contextPath }/guestbook/deleteform?no=${v.no}">삭제</a></td>
									</tr>
									<tr>
										<td colspan=4>${v.content }</td>
									</tr>
								</table> <br />
							</li>
						</ul>
					</c:forEach>
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
		$.ajax({

			url : "${pageContext.request.contextPath }/api/guestbook/list",
			type : "post",
			//contentType : "application/json",
			//data : {name: ”홍길동"},

			//dataType : "json",
			success : function(result){
				alert(result);
				/*성공시 처리해야될 코드 작성*/
			
			},
			
			error : function(XHR, status, error) {
			console.error(status + " : " + error);
			}
			});
	});
	
</script>

</html>