<%@ page import="beans.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pagina Inicial</title>
</head>
<body>
	<jsp:include page="Cabecalho.jsp"></jsp:include>
	<h1>Painel Principal</h1>

<%
	Usuario usuAutenticado = (Usuario)session.getAttribute("usuAutenticado");
	out.print("Seja Bem vindo "+usuAutenticado.getNome());
%>
</body>
</html>