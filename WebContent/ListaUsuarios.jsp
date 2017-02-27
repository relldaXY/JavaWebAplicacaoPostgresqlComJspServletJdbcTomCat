<%@ page import="java.util.*, jdbc.*, controle.*, beans.*" %>
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
	List<Usuario> listaResultado = (List<Usuario>)request.getAttribute("lista");

%>
	<table border="1">
		<tr bgcolor="#eaeaea">
			<th>Id</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Excluir</th>
			<th>Alterar</th>
		</tr>


	
<%
for(Usuario u: listaResultado){

%>
		<tr >
			<th><%=u.getId()%></th>
			<th><%=u.getNome()%></th>
			<th><%=u.getEmail()%></th>
			<th><a href="UsuarioControlador?acao=ex&id=<%=u.getId()%>">Excluir</a>
			<th><a href="UsuarioControlador?acao=alt&id=<%=u.getId()%>">Alterar</a>
		</tr>
<%
}
%>
</table>

</body>
</html>