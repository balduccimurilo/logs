package main;

import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.LinkedList;

import main.leitura.Leitura;
import main.operacao.Format;
import main.operacao.Operacao;

public class Main {

	public static void main(String[] args) throws SQLException, InterruptedException, ParseException {
		Leitura ler = new Leitura();
		
		
		File directory = new File("./logArchive");
		File[] archivesList = directory.listFiles();
		LinkedList<Operacao> list = ler.ler(archivesList[2].getName());
		
//		LinkedList<Operacao> list = ler.ler("0001_        00000016_05122019010004.EJMC");
//		LinkedList<Operacao> list = ler.ler("0001_0000000000000001_1501020010005.EJMC");
//		LinkedList<Operacao> list = ler.ler("19022000 (2).ejm");
		
//		InserirNoBD insere = new InserirNoBD(list);
		
//		@SuppressWarnings("deprecation")
//        java.sql.Timestamp ts = new java.sql.Timestamp(
//                java.util.Date.parse(list.get(0).getData() + " " + list.get(0).getHora()));
//        ps.setTimestamp(17, ts);
//		
//			for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getTipo() == 0) System.out.println("DEPOSITO");
//			else if(list.get(i).getTipo() == 1) System.out.println("DEPOSITO SANGRIA");
//			else if(list.get(i).getTipo() == 2) System.out.println("RECOLHIMENTO");
//			System.out.println();
//			System.out.println("DATA: " + list.get(i).getData());
//			System.out.println("HORA: " + list.get(i).getHora());
//			System.out.println("ID ADM: " + list.get(i).getId_atm());
//			System.out.println("SEQUENCIA: " + list.get(i).getSequencia());
//			System.out.println("ID OPERADOR: " + list.get(i).getId_operador());
//			System.out.println("NOME OPERADOR: " + list.get(i).getNome_operador());
//			System.out.println("ID COLETA: " + list.get(i).getId_coleta());
//			System.out.println("ID SANGRIA: " + list.get(i).getId_sangria());
//			System.out.println("PDV: " + list.get(i).getPdv());
//			System.out.println("CODIGO DO LACRE: " + list.get(i).getCodigo_lacre());
//			System.out.println("TOTAL: " + list.get(i).getTotal());
//			System.out.println("TOTAL (A + B): " + list.get(i).getValorAB());
//			System.out.println("DENOMINACAO 2: " + list.get(i).getDenominacao(0));
//			System.out.println("DENOMINACAO 5: " + list.get(i).getDenominacao(1));
//			System.out.println("DENOMINACAO 10: " + list.get(i).getDenominacao(2));
//			System.out.println("DENOMINACAO 20: " + list.get(i).getDenominacao(3));
//			System.out.println("DENOMINACAO 50: " + list.get(i).getDenominacao(4));
//			System.out.println("DENOMINACAO 100: " + list.get(i).getDenominacao(5));
//			System.out.println("\n************************************\n\n");
//			System.out.println(Timestamp.valueOf(Format.formatter(list.get(1).getData(), list.get(1).getHora())));
			
		
		
		
		
		
		
		}
		
		
	}



