package main.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.LinkedList;

import main.operacao.Format;
import main.operacao.Operacao;



public class Dao {

	LinkedList<Operacao> list1 = new LinkedList<>();
	
	
	public void gravarBanco(Operacao op, Connection con) throws SQLException, ParseException {

		// Passando os parâmetros sql
		PreparedStatement stm = con.prepareStatement(
				"INSERT INTO TABELA ( TRANSACTION_TYPE, TERMINAL_ID, SEQUENCE_NB, OPERATOR_ID,"
						+ " OPERATOR_NAME,COLLECT_ID, SANGRIA_ID, PDV_NB, DENOMINATION_2, DENOMINATION_5,"
						+ " DENOMINATION_10, DENOMINATION_20, DENOMINATION_50, DENOMINATION_100, TOTAL, "
						+ " SEAL_CD, DATE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS);


		// Fazendo a atribuição no banco de dados
		
		// Abaixo o script da inserção no banco
		
//		stm.setString(2, op.getData());
//		stm.setString(3, op.getHora());
		stm.setString(1, op.getTipo());
		stm.setInt(2, op.getId_atm());
		stm.setInt(3, op.getId_operador());
		stm.setInt(4, op.getSequencia());
		stm.setString(5, op.getNome_operador());
		stm.setString(6, op.getId_coleta());
		stm.setInt(7, op.getId_sangria());
		stm.setInt(8, op.getPdv());
		stm.setInt(9, op.getDenominacao(0));
		stm.setInt(10, op.getDenominacao(1));
		stm.setInt(11, op.getDenominacao(2));
		stm.setInt(12, op.getDenominacao(3));
		stm.setInt(13, op.getDenominacao(4));
		stm.setInt(14, op.getDenominacao(5));
		stm.setInt(15, op.getTotal());
//		stm.setDouble(16, op.getValorAB());
		stm.setLong(16, op.getCodigo_lacre());
		stm.setTimestamp(17, Timestamp.valueOf(Format.formatter(op.getData(), op.getHora())));
		

			
		stm.execute();
		
//		ResultSet rst = stm.getGeneratedKeys();
//		while(rst.next()) {
//			Integer id = rst.getInt(1);
//			
//		}
//		 rst.close(); 
		

	}
}
