package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;

public class UsuarioDAO {
	private Connection c = Conexao.getConnection();
	
	public void cadastro(Usuario usuario){
	
		String sql = "insert into usuario (nome, email, senha) values (?,?,md5(?))"; //md5 --> senha criptografada
		
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
					
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Cadastrado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro - "+ e.getMessage());
		}
	}
	
	public void alterarCadastro(Usuario usuario){
		
		String sql = "update usuario set nome = ?, email = ?, senha = ?  where id = ?"; 
		
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, usuario.getNome());
			System.out.println("Aqui"+usuario.getNome());
			pstmt.setString(2, usuario.getEmail());
			pstmt.setString(3, usuario.getSenha());
			pstmt.setInt(4, usuario.getId());
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Alterado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro - "+ e.getMessage());
		}	
	}
	
	public void deletarCadastro(Usuario usuario){
		
		String sql = "delete from usuario where id = ?"; 
		
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, usuario.getId());
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Deletado com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro - "+ e.getMessage());
		}

	}
	
	public List<Usuario> buscarTodos(Usuario usuario){
		String sql = "Select * from usuario";
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			ResultSet resultados = pstmt.executeQuery();
			
			while(resultados.next()){
				Usuario u = new Usuario();
				u.setId(resultados.getInt("id"));
				u.setNome(resultados.getString("nome"));
				u.setEmail(resultados.getString("email"));
				u.setSenha(resultados.getString("senha"));
				
				lista.add(u);
			}
		} catch (SQLException e) {
			System.out.println("Erro - "+ e.getMessage());
		}
		return lista;
	}
	public Usuario buscaPorId(int id){
		Usuario uRetorno = null;
		
		String sql = "Select * from usuario where id=?";
		
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet resultado = pstmt.executeQuery();
			
			while(resultado.next()){
				
				uRetorno = new Usuario();
				uRetorno.setId(resultado.getInt("id"));
				uRetorno.setNome(resultado.getString("nome"));
				uRetorno.setEmail(resultado.getString("email"));
				uRetorno.setSenha(resultado.getString("senha"));
				
			}
			System.out.println("Encontrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro SQL - "+ e.getMessage());
		}
		return uRetorno;
		
		
	}
	
	
	public Usuario autenticacao(Usuario u){
		Usuario uRetorno = null;
		
		String sql = "Select * from usuario where email = ? and senha = ?";
		
		try {
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, u.getEmail());
			pstmt.setString(2, u.getSenha());
			
			ResultSet resultado = pstmt.executeQuery();
			
			while(resultado.next()){
				
				uRetorno = new Usuario();
				uRetorno.setId(resultado.getInt("id"));
				uRetorno.setNome(resultado.getString("nome"));
				uRetorno.setEmail(resultado.getString("email"));
				uRetorno.setSenha(resultado.getString("senha"));
				
			}
			System.out.println("Encontrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro SQL - "+ e.getMessage());
		}
		return uRetorno;
		
		
	}
	
	
}