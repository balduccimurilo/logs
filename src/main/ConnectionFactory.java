package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public  static Connection recuperarConexao() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/logbanco?useTimezone=true&serverTimezone=UTC","root","root");
		
		if (con != null) {
			System.out.println("Banco conectado com sucesso!");
		}
		return con;
	}
}
