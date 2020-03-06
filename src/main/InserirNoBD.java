package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import main.operacao.Operacao;

public class InserirNoBD {
	LinkedList<Operacao> list;
	Connection con;

	public InserirNoBD(LinkedList<Operacao> list) throws SQLException {
		this.list = list;
		con = GetConnection.connect();
		Statement stm = con.createStatement();
		stm.execute("insert into teste (nome) values ('joao')");
	}
}
