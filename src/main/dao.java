package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.operacao.Operacao;

public class dao {

	public void gravarBanco(Operacao op, Connection con) throws SQLException {

		// Passando os parâmetros sql
		PreparedStatement stm = con.prepareStatement(
				"INSERT INTO TRANSACTION" + "TRANSACTION_TYPE" + "TERMINAL_ID" + "SEQUENCE_NB" + "OPERATOR_ID"
						+ "OPERATOR_NAME" + "COLLECT_ID" + "SANGRIA_ID" + "PDV_NB" + "DENOMINATION_2" + "DENOMINATION_5"
						+ "DENOMINATION_10" + "DENOMINATION_20" + "DENOMINATION_50" + "DENOMINATION_100" + "TOTAL"
						+ "SEAL_CD" + "DATE TIMESTAMP VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS);

		stm.executeUpdate();

		// Fazendo a atribuição no banco de dados
		// Abaixo o script da inserção

		stm.setInt(1, op.getTipo());

	}
}
