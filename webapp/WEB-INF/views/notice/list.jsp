<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 목록22</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<style>
			:link {
				text-decoration : none;
			} 
			:visited{
				color: blue;
			}
		</style>
	</head>
	<body>
		<div class="container">
		  <h2>공지사항 목록</h2>
		  <div class="panel panel-default">
		    <div class="panel-heading">
		    <form class="form-inline" action="/action_page.php">
			  <div class="form-group">
			    <label for="id">id:</label>
			    <input type="text" class="form-control" id="id">
			  </div>
			  <div class="form-group">
			    <label for="pw">pw:</label>
			    <input type="password" class="form-control" id="pw">
			  </div>
			  <button type="submit" class="btn btn-default">로그인</button>
			</form>
		    </div>
		    <div class="panel-body">
		    <div class="table-responsive">          
			  <table class="table table-hover">
			    <thead>
			      <tr>
			        <tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성날짜</th>
						<th>조회수</th>	
					</tr>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach items="${nList }" var="notice" varStatus="status"> 
					<tr> <!-- varStatus="status"는 번호들을 1부터 쭉 출력되게 해줌 -->
						<td>${status.count }</td>
						<td><a href="/notice/detail.do?notice-no=${notice.noticeNo }">${notice.noticeSubject }</a></td>
						<td>${notice.noticeWriter }</td>
						<td>${notice.noticeDate }</td>
						<td>${notice.viewCount }</td>
					</tr>		
				  </c:forEach>
				  	<tr>
					 <form action="#" method="post">
				  		<td>
				  			<select>
				  				<option>제목</option>
				  				<option>내용</option>
				  				<option>작성자</option>
				  			</select>
				  		</td>
				  		<td>
				  			<input type=text">
				  		</td>
				  		<td colspan=3>
				  			<input type="submit" value="검색" >
				  		</td>
				  	</form>
				  	</tr>
				  	<tr>
		        		<td colspan ="5" align="center">
		        			${pageNavi } 
		        		</td>
		        	</tr>
			    </tbody>
			  </table>
			  </div>
		    </div>
		    <div class="panel-footer">공지사항 관리자 : kh정보교육원(khadmin@gmail.com)</div>
		  </div>
		</div>
	</body>
</html>