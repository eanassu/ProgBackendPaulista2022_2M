<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.dao.DaoFuncionario"%>
<%@page import="br.vemprafam.pojo.Funcionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="fam" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Alteração de Dados</title>
</head>
<body>
<%
int re = Integer.parseInt(request.getParameter("re"));
DaoFuncionario dao = new DaoFuncionario();
Funcionario f = dao.buscarPeloRe(re);
SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
String dataAdmStr = format.format(f.getDataAdmissao());
%>
<form action="alterarFuncionario">
RE:<input type="text" name="re" value="<%=f.getRe()%>"/><br/>
nome:<input type="text" name="nome" value="<%=f.getNome()%>"/><br/>
data admissão:<fam:campoData id="dataAdm" value="<%=dataAdmStr%>"/><br/>
salário:<input type="text" name="salario" value="<%=f.getSalario()%>"/><br/>
e-mail:<input type="text" name="email" value="<%=f.getEmail()%>"/><br/>
<input type="submit" value="ok"/>
</form>
<br/>
<a href='/Projeto'>voltar</a>
</body>
</html>