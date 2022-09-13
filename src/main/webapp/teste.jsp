<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testes JSP</title>
</head>
<body>
<%
int x = 0;
String mensagem = "Bem vindo!";
out.println(mensagem);
%>
<br/>
<%=mensagem %>
<br/>
<%=x %>
</body>
</html>