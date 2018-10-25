<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%-- <%@ page isELIgnored="true" %>--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>EL디폴트 객체 (11개)</title>
</head>
<body>
<%
// 테스트를 위한 Scope객체에 데이터 저장
String today = String.format("%1$tF %1$tT", Calendar.getInstance());
request.setAttribute("today", today);
session.setAttribute("id", "bangry");
String[] names = {"김기정", "박기정", "최기정"};
%>

<%=request.getAttribute("today") %>
${requestScope.today}<br>
${today}<br>

<%=session.getAttribute("id") %>
<%-- <%=pageContext.findAttribute("id") %> --%>
<jsp:useBean id="dog" class="kr.or.kosta.jsp.el.Dog" scope="page"/>
<jsp:setProperty property="name" name="dog" value="루니"/>

<jsp:useBean id="student" class="kr.or.kosta.jsp.el.Student" scope="page"/>
<jsp:setProperty property="name" name="student" value="건후"/>
<jsp:setProperty property="dog" name="student" value="${dog}"/>
<%--
<jsp:getProperty property="id" name="student"/>
<jsp:getProperty property="name" name="student"/>
<jsp:getProperty property="dog" name="student"/>
--%>	
${student.name }
${student.dog.name }<br>
${student.setName("기정") }<br>
${student.name }<br>


</body>
</html>