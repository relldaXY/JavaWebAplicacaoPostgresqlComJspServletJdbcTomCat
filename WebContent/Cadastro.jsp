<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar</title>
</head>
<body>
	<jsp:include page="Cabecalho.jsp"></jsp:include>
	<form action="SalvarCadastro.jsp" method ="get">
	<label>Nome</label>
	<input type="text" name="nome">
	<label>Email</label>
	<input type="text" name="email">
	<label>Senha</label>
	<input type="password" name="senha">
	
	<input type="submit" value="cadastrar">
	</form>
</body>
</html>