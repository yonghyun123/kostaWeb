<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>�޽���: ${requestScope.message }</h2>

<h2>����</h2>
<ul>
<c:forEach var="team" items="${requestScope.list}">
	<li>${team}</li>
</c:forEach>
	
</ul>

</body>
</html>