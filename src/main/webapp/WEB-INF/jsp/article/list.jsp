<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.harunice.makeEvent.dto.Article" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 사이트 - 게시물 리스트</title>
</head>
<body>
<h1>게시물 리스트</h1>
<h2>전체 게시물 개수 : ${totalCount} </h2>
	<!-- el의 장점은 request.getAttribute("list") 할 필요가 없다. -->
	<c:forEach items="${list}" var="article">
		<section>
			번호 : ${article.id}, 제목 : ${article.title}
		</section>
		<hr>
	</c:forEach>
</body>
</html>