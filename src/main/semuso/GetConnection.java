package main.semuso;
//package main.banco;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.LinkedList;
//import java.util.Properties;
//
//import main.operacao.Operacao;
//
//public class GetConnection {
//	private static Connection conn = null;
//	
//		
//	public static Connection connect() {
//		if (conn == null) {
//			try {
//				Properties props = loadProperties();
//				String url = props.getProperty("dburl");
//				conn = DriverManager.getConnection("jdbc:mysql://localhost/logbanco?useTimezone=true&serverTimezone=UTC", "root", "root");
//			} catch (SQLException e) {
//				e.getMessage();
//			}
//		}
//		if (conn != null) {
//			System.out.println("Conectado com sucesso ao Banco de Dados.");
//		}
//
//		return conn;
//	}
//
//	public static void closeConnection() {
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.getMessage();
//			}
//		}
//	}
//
//	private static Properties loadProperties() {
//		try (FileInputStream fs = new FileInputStream("db.properties")) {
//			Properties props = new Properties();
//			props.load(fs);
//			return props;
//		} catch (IOException e) {
//			e.getMessage();
//		}
//		return null;
//	}
//
//	public static void closeStatment(Statement st) {
//		if (st != null) {
//			try {
//				st.close();
//			} catch (SQLException e) {
//			}
//		}
//	}
//
//	public static void closeResultSet(ResultSet rs) {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//			}
//		}
//	}
//
//}

