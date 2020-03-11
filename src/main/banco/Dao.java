package main.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.operacao.Operacao;



public class Dao {

	public void gravarBanco(Operacao op, Connection con) throws SQLException {

		// Passando os parâmetros sql
		PreparedStatement stm = con.prepareStatement(
				"INSERT INTO TRANSACTION" + "TRANSACTION_TYPE" + "TERMINAL_ID" + "SEQUENCE_NB" + "OPERATOR_ID"
						+ "OPERATOR_NAME" + "COLLECT_ID" + "SANGRIA_ID" + "PDV_NB" + "DENOMINATION_2" + "DENOMINATION_5"
						+ "DENOMINATION_10" + "DENOMINATION_20" + "DENOMINATION_50" + "DENOMINATION_100" + "TOTAL" + "TOTAL_AB"
						+ "SEAL_CD" + "DATE TIMESTAMP VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS);


		// Fazendo a atribuição no banco de dados
		
		// Abaixo o script da inserção no banco
		stm.setInt(1, op.getTipo());
		stm.setString(2, op.getData());
		stm.setString(3, op.getHora());
		stm.setInt(4, op.getId_atm());
		stm.setInt(5, op.getId_operador());
		stm.setInt(6, op.getSequencia());
		stm.setString(7, op.getNome_operador());
		stm.setString(8, op.getId_coleta());
		stm.setInt(9, op.getId_sangria());
		stm.setInt(10, op.getPdv());
		stm.setInt(11, op.getDenominacao(0));
		stm.setInt(12, op.getDenominacao(1));
		stm.setInt(13, op.getDenominacao(2));
		stm.setInt(14, op.getDenominacao(3));
		stm.setInt(15, op.getDenominacao(4));
		stm.setInt(16, op.getDenominacao(5));
		stm.setInt(17, op.getTotal());
		stm.setDouble(18, op.getValorAB());
		stm.setLong(19, op.getCodigo_lacre());
			
		stm.executeUpdate();
		
//		ResultSet rst = stm.getGeneratedKeys();
//		while(rst.next()) {
//			Integer id = rst.getInt(1);
//			
//		}
//		 rst.close(); 
		

	}
}
