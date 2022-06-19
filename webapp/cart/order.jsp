<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="bookstore.book"%>
<%@ page import="bookstore.Bookdao"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="Stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<%
	request.setCharacterEncoding("UTF-8");
	String cartId = session.getId();
	String shipping_cartId = "";
	String shipping_name = "";
	String shipping_shippingDate = "";
	String shipping_country = "";
	String shipping_zipCode = "";
	String shipping_addressName = "";
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			Cookie thisCookie = cookies[i];
			String n = thisCookie.getName();
			if (n.equals("Shipping_cartId"))
				shipping_cartId = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_name"))
				shipping_name = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_shippingDate"))
				shipping_shippingDate = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_country"))
				shipping_country = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_zipCode"))
				shipping_zipCode = URLDecoder.decode((thisCookie.getValue()), "utf-8");
			if (n.equals("Shipping_addressName"))
				shipping_addressName = URLDecoder.decode((thisCookie.getValue()), "utf-8");
		}
	}
%>
<html>
<head>
<title>주문 정보</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문 정보</h1>
		</div>
	</div>
	<div class="container col-8 alert alert-info">
		<div class="text-center ">
			<h1>영수증</h1>
		</div>
		<div class="row justify-content-between">
			<div class="clo-4" align="left">
				<strong>배송 주소</strong><br>
				성명 : <%out.println(shipping_name);%><br>
				우편번호 : <%out.println(shipping_zipCode);%><br>
				주소 : <%out.println(shipping_addressName);%> (<%out.println(shipping_country);%>)<br>
			</div>
			<div class="col-4" align="right">
				<p><em>배송일: <%out.println(shipping_shippingDate);%></em>
			</div>
		</div>
		<div>
			<table class="table table-hover">
				<tr>
					<th class="text-center">카트 번호</th>
					<th class="text-center">책 제목</th>
					<th class="text-center">작가</th>
					<th class="text-center">주문 수량</th>
					<th class="text-center">총 가격</th>
				</tr>
				<tr class="select" align= 'center'>
				<td>1</td>
				<td>어느 날, 내 죽음에 네가 들어왔다</td>
				<td>세이카 료겐</td>
				<td>1</td>
				<td>13500</td>
				<tr class="another" align='center'>
				<td>2</td>
				<td>소문</td>
				<td>오기와라 히로시</td>
				<td>2</td>
				<td>29700</td>
				<tr>
					<td></td>
					<td></td>
					<td class="text-right"><strong>총액: </strong></td>
					<td class="text-center text-danger"><strong>57000원</strong></td>
				</tr>
			</table>
			<a href="http://localhost:8080/jwbook/guest/guest_index.jsp" class="btn btn-success"
				role="button">주문완료</a>
		</div>
	</div>
</body>
</html>
