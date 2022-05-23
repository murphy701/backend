<%-- books.jsp --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bookstore.book"%>
<jsp:useBean id="bookDAO" class="bookstore.Bookdao" scope="session" />
<html>
<head>
<link rel="Stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>도서 목록</title>
</head>
<body>

	<%
		ArrayList<book> listOfBooks = bookDAO.getAllBooks();
	%>
	<div class="container">
		<%
			for (int i = 0; i < listOfBooks.size(); i++) {
				book book = listOfBooks.get(i);
		%>
		<p><h5><b>[<%=book.getCategory()%>] <%=book.getName()%></b></h5>
		<p style="padding-top: 20px"><%=book.getStock()%> <%=book.getBookid() %>
		<p><%=book.getWriter()%> | <%=book.getDescrip()%> | <%=book.getPrice()%>원
		<hr>
		<%
			}
		%>
	</div>
</body>
</html>