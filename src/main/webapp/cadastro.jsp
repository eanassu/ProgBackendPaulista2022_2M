<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="fam" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<meta charset="ISO-8859-1">
<title>Cadastro de Funcionário</title>
</head>
<body>
<form action="cadastrarFuncionario">
RE:<input type="text" name="re"/><br/>
nome:<input type="text" name="nome"/><br/>
data admissão:<fam:campoData id="dataAdm"/><br/>
salário:<input type="text" name="salario"/><br/>
e-mail:<input type="email" name="email"/><br/>
<input type="submit" value="ok"/>
</form>
<br/>
<a href='/Projeto'>voltar</a>
</body>
</html>