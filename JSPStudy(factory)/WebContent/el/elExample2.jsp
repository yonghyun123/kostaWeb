<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL디폴트 객체 (11개)</title>
</head>
<body>
<%--${pageScope}<br><br><br> --%>	
${requestScope}<br><br><br>
${sessionScope}<br><br><br>
<%-- ${applicationScope}<br><br><br>--%>
${param.name }, ${param['name'] }<br><br>
${paramValues.hobby[0] }, ${paramValues.hobby[1]}<br><br>
${header['user-agent'] }<br><br>
${headerValues['xxx'] }<br><br>
쿠키: ${cookie.loginId.name }<br><br> -> loginId?
쿠키 값: ${cookie.loginId.value }
</body>
</html>