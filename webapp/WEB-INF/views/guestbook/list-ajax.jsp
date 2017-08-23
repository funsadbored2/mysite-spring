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
<link
	href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>


<title>ajax-mysite</title>
</head>
<body>

	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>

		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>

		<div id="wrapper">
			<div id="content">
				<div id="guestbook">
					<button type='button'
						class='btn btn-warning btn-xs deleteModal'>삭제</button>
						<br/>
						<br/>
					<form action="${pageContext.request.contextPath }/api/guestbook/add" method="post">
						<table>
							<tr>
								<td>이름</td>
								<td><input type="text" id="name" name="name" /></td>
								<td>비밀번호</td>
								<td><input type="password" id="ps" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea id="content" name="content"
										id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input id="write-form"
									type="button" class="btn btn-info btn-sm" VALUE=" 확인 " /></td>
							</tr>
						</table>
					</form>

					<!-- 리스트 뿌려지는 부분 -->
					<ul id="guestbook-list">

					</ul>
				</div>
				<!-- /guestbook -->
			</div>
			<!-- Modal content-->
			<!-- Modal -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">삭제창</h4>
						</div>
						<div class="modal-body">
							<p>삭제를 위해 비밀번호를 입력해주세요.</p>
							<form method="post"
								action="${pageContext.request.contextPath }/guestbook/delete">
								<input type="hidden" name = "deleteNo" value = "" class = "deleteNo">
								<label>비밀번호</label>
								<input id= "deletePassword" type="password" name="password">
								<input id = "deleteCheckButton" type="button" class ="btn btn-info btn-xs" value="확인">
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
						</div>
					</div>
				</div>
			</div>

			<!-- /content -->
		</div>
		<!-- /wrapper -->

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>

	</div>
	<!-- /container -->

</body>

<script type="text/javascript">
	$(document).ready(function() {
		//리스트 출력
		fetchList();

		$("#guestbook-list").on("click",".deleteModal", function() {
			
			console.log("전송 성공함");
			
					var no = $(this).data("delno");

				$(".deleteNo").val(no);			
			$("#myModal").modal();
		
		});
		
		$("#deleteCheckButton").on("click",function(){
			console.log("탈락 전송 성공");
			var deleteNo = $(".deleteNo").val();
			var password = $("#deletePassword").val();
			console.log(deleteNo);
			console.log(password);
			
			$.ajax({
				url : "${pageContext.request.contextPath }/api/guestbook/delete",	
				type : "post",
				contentType : "application/json",
				data : JSON.stringify({no: deleteNo, password: password}),
				dataType : "json",
				success : function(list) {
					console.log(resultVo);
					if(resultVo.result == "success"){
						$("#li-"+resultVo.data).remove();	
						$("#del-pop").modal("hide")
						$("#modalPassword").val("");
						$("#modalNo").val("");
					}else{
						console.log(resultVo.failMsg);
						$("#del-pop").modal("hide")
					}	
				}, 
				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});
			
		});

		//저장버튼 출력
		$("#write-form").on("click", function() {
			event.preventDefault();
			console.log("전송 성공함");

			var guetbookInfo = {
				name : $("[name = name]").val(),
				password : $("[name=password]").val(),
				content : $("[name=content]").val()
			}

			$.ajax({

				url : "${pageContext.request.contextPath}/api/guestbook/add",
				type : "post",
				contentType : "application/json",
				data : JSON.stringify(guetbookInfo),

				dataType : "json",
				success : function(guestbookVo) {
					console.log(guestbookVo);
					render(guestbookVo, "up");
				},

				error : function(XHR, status, error) {
					console.error(status + " : " + error);
				}
			});

		});

	});

	function fetchList() {

		$.ajax({

			url : "${pageContext.request.contextPath }/api/guestbook/list",
			type : "post",
			//contentType : "application/json",
			//data : {name: ”홍길동"},

			dataType : "json",
			success : function(gbList) {

				for (var i = 0; i < gbList.length; i++) {

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
		str += "	<table class>";
		str += "           <tr>";
		str += "               <td>[" + GuestbookVo.no + "] </td>";
		str += "               <td>" + GuestbookVo.name + "</td>";
		str += "               <td>" + GuestbookVo.regDate + "</td>";
		str += "               <td><button type = 'button' class ='btn btn-warning btn-xs deleteModal' data-delno = '" + GuestbookVo.no + "'>삭제</button></td>";
		str += "           </tr>";
		str += "           <tr>";
		str += "               <td colspan=4>" + GuestbookVo.content+ "  </td>";
		str += "           </tr>";
		str += "	</table>";
		str += "	<br/>";
		str += "</li>";

		if (updown == "down") {
			$("#guestbook-list").append(str);
		} else if (updown = "up") {
			$("#guestbook-list").prepend(str);
		} else {
			$("#guestbook-list").append(str);
		}
	}
</script>

</html>