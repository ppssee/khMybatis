<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 수정</title>
</head>
<body>
	<h1>공지사항 수정</h1>
	<form action="/notice/modify.do" method="post">
		<input type="hidden" name="notice-no" value="${notice.noticeNo }">
		제목 : <input type="text" name="subject" value="${notice.noticeSubject }"> <br>
		내용 : <textarea name="content" rows="5" cols="40">${notice.noticeContent }</textarea><br>
		
		<input type="submit" value="수정">
		<input type="reset" value="취소">
		<input type="button" value="뒤로가기" onclick="location.href='/notice/detail.do?notice-no=${notice.noticeNo}'">
		<input type="button" value="리스트로" onclick="location.href='/notice/list.do'">
	</form>
</body>
</html>