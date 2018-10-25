<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<%
String url = "http://www.naver.com";
%>

<c:url var="url" value="http://www.naver.com">
 <c:param name="id" value="bangry"/>
 <c:param name="name" value="김용현"/>
</c:url>

<a href="${url}">이동</a>
</body>
</html>