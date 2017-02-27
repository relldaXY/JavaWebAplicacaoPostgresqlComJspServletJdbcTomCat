<%@ page import="beans.*, jdbc.*, teste.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Salvar Cadastro</title>
</head>
<body>
	<jsp:include page="Cabecalho.jsp"></jsp:include>
	<%
		String sNome = request.getParameter("nome");
		String sEmail = request.getParameter("email");
		String sSenha = request.getParameter("senha");

		Usuario u = new Usuario();
		u.setNome(sNome);
		u.setSenha(sSenha);
		u.setEmail(sEmail);

		UsuarioDAO uDao = new UsuarioDAO();
		uDao.cadastro(u);
		
	%>

	<h1>Salvo Com Sucesso</h1>
</body>
</html>