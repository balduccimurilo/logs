package main.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException, InterruptedException, ClassNotFoundException {
		
		Connection con = ConnectionFactory.getConnection();
		
		
		// Para obter a conexão com o banco de dados através do ConnectionFactory
		
	
	}

}
