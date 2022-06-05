<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("pw");
    // DB연결에 필요한 변수 선언
	String url = "jdbc:h2:tcp://localhost/~/jwbookdb";
	String uid = "jwbook";
	String upw = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from userdb where id = ? and pw = ?";
	
	try{
		// 드라이버 호출
		Class.forName("org.h2.Driver");
		
		// conn 생성
		conn = DriverManager.getConnection(url, "uid", "upw");
		
		// pstmt 생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, passwd);
		
		// sql실행
		rs = pstmt.executeQuery();
		
		if(rs.next()){ // 로그인 성공(인증의 수단 session)
			id = rs.getString("id");
			String name = rs.getString("name");
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			response.sendRedirect("guest_index.jsp"); // 페이지이동
			
		} else{ // 로그인 실패
			response.sendRedirect("login.jsp"); // 실패 페이지
		}
	} catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("login.jsp"); // 에러가 난 경우도 리다이렉트
	} finally{
		try{
			if(conn != null) conn.close();
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
 %>
