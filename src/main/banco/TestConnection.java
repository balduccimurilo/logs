package main.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		
		Connection con = ConnectionFactory.recuperarConexao();
		
		
		// Para obter a conex�o com o banco de dados atrav�s do ConnectionFactory
		
	
	}

}
