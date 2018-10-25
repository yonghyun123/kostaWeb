<%@page import="org.apache.jasper.tagplugins.jstl.core.ForTokens"%>
<%@page import="kr.or.kosta.jsp.dao.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<String> teams = new ArrayList<String>();
teams.add("화나 이글즈");
teams.add("두산 타이거즈");
teams.add("SK 쌍방울");
request.setAttribute("teams", teams);

List<User> users = new ArrayList<User>();

users.add(new User("bangry", "김용현", "1111", "model9960@naver.com","2222"));
users.add(new User("bangry", "김용현", "1111", "model9960@naver.com","2222"));
users.add(new User("bangry", "김용현", "1111", "model9960@naver.com","2222"));
users.add(new User("bangry", "김용현", "1111", "model9960@naver.com","2222"));
request.setAttribute("user", users);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
<c:forEach var="i" begin="1" end="10">
${i} : 김기정입니다. <br>
</c:forEach>
<table border="1">
<c:forEach var="i" begin="2" end="9">
	<tr>
	<c:forEach var="j" begin="1" end="9">
		<td>${i} * ${j} = ${i*j}</td>
	</c:forEach>
	</tr>
</c:forEach>
</table>
<select>
	<c:forEach var="team" items="${teams}">
		<option>${team}</option>
	</c:forEach>
</select>

<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th>가입일자</th>
	</tr>
	<c:choose>
		<c:when test="${not empty user }">
		<c:forEach var="user" items="${user}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${x.index}${user.id }</td>
				<td>${user.name }</td>
				<td>${user.passwd }</td>
				<td>${user.email }</td>
				<td>${user.regdate }</td>
			</tr>
		</c:forEach>		
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="5">회원이 존재하지 않습니다.</td>
			</tr>
		</c:otherwise>
	</c:choose>
	
</table>

<%
String son = "920605-1001816";
request.setAttribute("son", son);
%>

<c:forTokens var="token" items="${son}" delims="-">
${token },
</c:forTokens>

</body>
</html>