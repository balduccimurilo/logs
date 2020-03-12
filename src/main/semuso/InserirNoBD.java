package main.semuso;
//package main.banco;
//
//import java.security.GeneralSecurityException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.LinkedList;
//import main.operacao.Operacao;
//
//public class InserirNoBD {
//	LinkedList<Operacao> list;
//	Connection con;
//
//	public InserirNoBD(LinkedList<Operacao> list) throws SQLException {
//		this.list = list;
//		
//		
//		con = GetConnection.connect();
//
//		Operacao operacao = new Operacao();
//
//		PreparedStatement stm = con.prepareStatement("insert into bancolog(?) values ? ");
//		stm.execute();
//
//		stm.setInt(1, operacao.getTipo());
//		stm.setString(2, operacao.getData());
//		stm.setString(3, operacao.getHora());
//		stm.setInt(4, operacao.getId_operador());
//		
//
//	}
//
//}
