<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 목록</title>
		<style>
			table {
				border : 1px solid black;
				border-collapse : collapse;
			}
			th, td{
				border : 1px solid black;
			}
		</style>
	</head>
	<body>
		<h1>공지사항 목록</h1>
		<form action="" method="">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성날짜</th>
				<th>조회수</th>	
			</tr>
			<c:forEach items="${nList }" var="notice" varStatus="status"> 
			<tr> <!-- varStatus="status"는 번호들을 1부터 쭉 출력되게 해줌 -->
				<td>${status.count }</td>
				<td><a href=>${notice.noticeSubject }</a></td>
				<td>${notice.noticeWriter }</td>
				<td>${notice.noticeDate }</td>
				<td>${notice.viewCount }</td>
			</tr>		
			</c:forEach>
			
		</table>
		</form>
	</body>
</html>