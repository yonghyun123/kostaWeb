<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String message = "jstl <연습>입니다.";
request.setAttribute("message", message);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
${message }
<c:out value="김기정"/>
<c:out value="${message123 }" default="기본메시지 입니다..."/>
</body>
</html>