<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
<br><br>
<div align="center"><font size=5> 회원정보 입력하기 </font></div> <br>
<div align="center">
<br><br>
<form method="post" action="/jwbook/usercontrol">
	<table border=1 width=600>

		<tr>
			<td  align=center>id </td>
			<td><input  type=text  name=phone size=20></td>
		</tr>
		<tr>
			<td  align=center>비밀번호 </td>
			<td><input  type=text  name=address size=20></td>
		</tr>
		<tr>
			<td  align=center>전화번호 </td>
			<td><input  type=text  name=joindate size=20></td>
		</tr>
		<tr>
			<td  align=center>주소 </td>
			<td><input  type=text  name=grade size=20></td>
		</tr>
		<tr>
			<td  align=center>이메일 주소 </td>
			<td><input  type=text  name=city size=20> </td>
		</tr>
		<tr>
			<td colspan=2  align=center>
				<input  type=submit  value="등록"> &emsp;
			</td>
		</tr>
	</table>
</form>
</div>
</section>
