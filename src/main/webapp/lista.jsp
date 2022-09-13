<%@page import="br.vemprafam.pojo.Funcionario"%>
<%@page import="java.util.List"%>
<%@page import="br.vemprafam.dao.DaoFuncionario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista</title>
</head>
<body>
<table border='1'>
	<tr>
    <th>RE</th><th>nome</th><th>data adm.</th><th>salário</th>
    </tr>
    <%-- comentário em JSP --%>
	<%
	DaoFuncionario dao = new DaoFuncionario();
	List<Funcionario> lista = dao.getLista();
	for( Funcionario f: lista ) {
	%>
		<tr>
			<td><%=f.getRe()%></td>
			<td><%=f.getNome()%></td>
			<td><%=f.getDataAdmissao()%></td>
			<td><%=f.getSalario()%></td>
		</tr>	
	<%
	} 
	%>
</table>
</body>
</html>