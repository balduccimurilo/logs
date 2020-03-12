package main.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection recuperarConexao() throws SQLException, InterruptedException {

		String url = "jdbc:postgresql://localhost:5432/transaction";
		String user = "postgres";
		String password = "root";	

//		String url = "jdbc:postgresql://192.168.14.71/postgres?/desafio01";
//		String user = "desafioacc01";
//		String password = "pwddesafioacc01";

		Connection con = DriverManager.getConnection(url, user, password);

		if (con != null) {
			System.out.println("Trying connect...");
			Thread.sleep(1000);
			System.out.println("Connected to PostgreSQL database!");
			Thread.sleep(1000);
		}
		return con;
	}
}
