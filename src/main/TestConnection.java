package main;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) throws SQLException {
		
		connectionFactory connectionFactory = new connectionFactory();
		Connection connection1 = connectionFactory.recuperarConexao();
		
		System.out.println("Banco de dados conectado com sucesso!");
		connection1.close();

	}

}
