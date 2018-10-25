<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<c:import url="https://www.naver.com" var="output"></c:import>
안녕하세요
한시간 남았네요 쓴세

<c:out value="${output }"></c:out>
</body>
</html>