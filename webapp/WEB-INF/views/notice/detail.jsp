<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세 조회</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>공지사항 상세 정보</h1>
	작성자 : ${notice.noticeWriter } / 작성날짜 : ${notice.noticeDate } / 조회수 : ${notice.viewCount }
	<h3>제목 : ${notice.noticeSubject }</h3><br>
	<p><strong>내용</strong> : ${notice.noticeContent }</p> <br><br>
	<form action="/notice/remove.do" method="post">
		<input type="hidden" value="${notice.noticeNo }" name="notice-no">
		<input type="button" value="목록으로" onclick="location.href='/notice/list.do'">
		<input type="button" value="수정하기" onclick="location.href='/notice/modify.do?notice-no=${notice.noticeNo}'">	
		<input type="submit" value=삭제하기 onclick="return deleteCheck();">
	</form>
	
	
	
	<script>
		function deleteCheck(){
			if(confirm("정말 삭제하시겠습니까?")){
				return true;
			}
			return false;
		}

	</script>
</body>
</html>