<%@ page import="beans.*,jdbc.*,controle.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Cabecalho.jsp"></jsp:include>
	<%
		Usuario usu = (Usuario)request.getAttribute("usuario");
	%>

	<form action="UsuarioControlador" method ="post">
	<input type="hidden" name="acao" value="salvar">
	
	<label>Id</label>
	<input size="5" type="text"  name="id" value="<%=usu.getId()%>">

	<label>Nome</label>
	<input type="text"  name="nome" value="<%=usu.getNome()%>">
	
	<label>Email</label>
	<input type="text"  name="email" value="<%=usu.getEmail()%>">
	
	<label>Senha</label>
	<input type="text"  name="senha" value="<%=usu.getSenha()%>">
	
	<input type="submit" value="salvar">
	</form>
</body>
</html>