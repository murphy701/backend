<%-- orderConfirmation.jsp --%>
<%-- 장바구니 결제내역을 보여주는 기능 --%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="bookstore.book"%>
<%@ page import="bookstore.Bookdao"%>
<%@page import="bookstore.cart"%>
<%@page import="bookstore.cartDAO"%>
<html>
<head>
<link rel="Stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>주문 정보</title>
</head>
<body>
	<jsp:include page="../guest/guest_top.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h3 class="display-8">주문 정보</h3>
		</div>
	</div>
	<div class="container col-6 alert alert-info">
		<div class="text-center ">
			<h1>결제 내역</h1>
		</div>
		<div class="row justify-content-between">
			<div class="clo-4" align="left">
				<strong>배송 주소</strong><br>
		<div>
			<table class="table table-hover">
				<tr>
					<th class="text-center">도서</th>
					<th class="text-center">#</th>
					<th class="text-center">가격</th>
					<th class="text-center">소계</th>
				</tr>
				<%
					int sum = 0;
					ArrayList<book> cartList = (ArrayList<book>) session.getAttribute("cartlist");
					if (cartList == null)
						cartList = new ArrayList<book>();
					for (int i = 0; i < cartList.size(); i++) { // 도서 리스트 하니씩 출력하기
						book book = cartList.get(i);
						int total = book.getPrice();
						sum = sum + total;
				%>
				<tr>
					<td class="text-center"><em><%=book.getName()%></em></td>
					<td class="text-center"><%=book.getPrice()%></td>
					<td class="text-center"><%=total%>원</td>
				</tr>
				<%
					}
				%>
			</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
