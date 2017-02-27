package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Usuario;
import jdbc.*;

/**
 * Servlet implementation class UsuarioControlador
 */
@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario u = new Usuario();
		String acao = request.getParameter("acao");
		UsuarioDAO uDao = new UsuarioDAO();
		
		if (acao != null && acao.equals("lis")) {
			List<Usuario> lista = uDao.buscarTodos(u);

			request.setAttribute("lista", lista);
			RequestDispatcher saida = request.getRequestDispatcher("ListaUsuarios.jsp");
			saida.forward(request, response);

		}else if(acao != null && acao.equals("ex")){
			String id = request.getParameter("id");
			u.setId(Integer.parseInt(id));
			uDao.deletarCadastro(u);
			response.sendRedirect("UsuarioControlador?acao=lis");
			
		}else if(acao != null && acao.equals("alt")){
			String id = request.getParameter("id");
			Usuario usuario = uDao.buscaPorId(Integer.parseInt(id));
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("AlterarCadastro.jsp").forward(request, response);
		
		}else if(acao != null && acao.equals("cad")){
			RequestDispatcher saida = request.getRequestDispatcher("Cadastro.jsp");
			saida.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		String sNome = request.getParameter("nome");
		String sEmail = request.getParameter("email");
		String sSenha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(sNome);
		usuario.setEmail(sEmail);
		usuario.setSenha(sSenha);
		usuario.setId(Integer.parseInt(sId));
		
		UsuarioDAO uDao = new UsuarioDAO();
		
		uDao.alterarCadastro(usuario);
		//PrintWriter out = response.getWriter();
		response.sendRedirect("UsuarioControlador?acao=lis");
	}

}
