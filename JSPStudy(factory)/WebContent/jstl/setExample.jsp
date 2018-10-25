<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="message" value="jstl <연습>입니다." scope="page"/>
<jsp:useBean id="dog" class="kr.or.kosta.jsp.el.Dog"/>
<c:set target="${dog}" value="루니" property="name"/>
<c:remove var="message"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
${message }
<c:out value="김기정"/>
<c:out value="${message}" default="기본메시지 입니다..."/><br>
강아지이름: ${dog.name}
</body>
</html>