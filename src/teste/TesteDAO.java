package teste;

import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import jdbc.UsuarioDAO;

public class TesteDAO {

	public static void main(String[] args) {
		//testCadastro();
		//testAlterar();
		//testDeletar();
		//testBuscarTodos();
	}
	
	public static void testCadastro(){
		Usuario usuario = new Usuario();
		usuario.setNome("iaap");
		usuario.setEmail("iaap@gmail.com");
		usuario.setSenha("kaaa");
		
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.cadastro(usuario);
	}
	
	public static void testAlterar(){
		Usuario usuario = new Usuario();
		usuario.setNome("p");
		usuario.setEmail("p@gmail.com");
		usuario.setSenha("pppp");
		usuario.setId(8);
		
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.alterarCadastro(usuario);
	}
	
	public static void testDeletar(){
		Usuario u = new Usuario();
		u.setId(6);
		
		UsuarioDAO uDao = new UsuarioDAO();
		uDao.deletarCadastro(u);
	}
	
	public static void testBuscarTodos(Usuario u){
		UsuarioDAO uDao = new UsuarioDAO();
		List<Usuario> listaResultado = new ArrayList<Usuario>();
		listaResultado = uDao.buscarTodos(u);
		
		for(Usuario user: listaResultado){
			System.out.println("Id: "+user.getId());
			System.out.println("Nome: "+user.getNome());
			System.out.println("Email: "+user.getEmail());
			System.out.println("Senha: "+user.getSenha());
		}
		
	}
}
