<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
</head>
<body>
	<h1>전화번호 리스트</h1>

	<p>입력한 전화번호 내역입니다.</p>

	<c:forEach items="${requestScope.pList}" var="pvo">

		<table border="1">

			<tr>

				<td>이름(name)</td>
				<td>${pvo.name}</td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td>${pvo.hp}</td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td>${pvo.company}</td>
			</tr>
			<tr>
				<td><a href="/phonebook4/phone/modifyForm?id=${pvo.personId}">수정</a></td>
				<td><a href="/phonebook4/phone/delete?id=${pvo.personId}">[삭제]</a></td>
			</tr>

		</table>
		<br>

	</c:forEach>

	<a href="/phonebook4/phone/writeForm">추가번호 등록</a>
</body>
</html>