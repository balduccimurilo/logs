package main.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection recuperarConexao() throws SQLException, InterruptedException {

		String url = "jdbc:postgresql://localhost:5432/transaction";
		String user = "postgres";
		String password = "root";

		Connection con = DriverManager
				.getConnection(url, user, password);
		


		if (con != null) {
			System.out.println("Trying connect...");
			Thread.sleep(4000);
			System.out.println("Connected to PostgreSQL database!");
			Thread.sleep(4000);
		}
		return con;
	}
}
