package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		Connection c = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Exemplo01", "postgres", "rellda");
			System.out.println("Conexao realizada com sucesso");
		} catch (ClassNotFoundException e) {
			System.out.println("ERRO - DRIVER "+ e.getMessage());
		} catch(SQLException e){
			System.out.println("ERRO - CONEXAO AO BD "+ e.getMessage());
		}
		return c;
		
	}
	
	
}
