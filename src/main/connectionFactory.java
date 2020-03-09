package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
	public  Connection recuperarConexao() throws SQLException {
		return  DriverManager
				.getConnection("jdbc:mysql://localhost/logbanco?useTimezone=true&serverTimezone=UTC","root","root");
		
	}
}
