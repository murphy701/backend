<%@page import="bookstore.book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	// 세션의 고유 아이디를 가져온다.
	String cartId = session.getId();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<title>장바구니</title>
</head>
<body>
	<jsp:include page="../guest/guest_top.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">장바구니</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left">
					<a href="deleteCart.jsp?cartid=<%=cartId%>" class="btn btn-danger">
					삭제하기
					</a>
					</td>
					<td align="right">
					<a href="ship?action=ship" class="btn btn-success">주문하기</a>
					</td>
				</tr>
			</table> 
		</div>
		<div style="padding-top:50px;" class="box">
		<div class="container">
		<ul class="container">
		<c:forEach var="</ul>
		</div>
			<a href="../guest/booklist.jsp" class="btn btn-secondary">&raquo; 쇼핑 계속하기</a>
		</div>
	</div>
</body>
</html>
