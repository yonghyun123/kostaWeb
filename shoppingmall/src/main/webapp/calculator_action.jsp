<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");
String op = request.getParameter("op");

System.out.println(num1);
System.out.println(num2);
System.out.println(op);

int result;
int n1 = Integer.parseInt(num1);
int n2 = Integer.parseInt(num2);
if(op.equals("*")){
	result = n1 * n2;
} else if(op.equals("/")){
	result = n1 / n2;
} else if(op.equals("-")){
	result = n1 - n2;
} else {
	result = n1 + n2;
}

out.println(result);
%>
