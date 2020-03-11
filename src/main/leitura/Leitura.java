package main.leitura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedList;

import main.banco.ConnectionFactory;
import main.banco.Dao;
import main.operacao.Operacao;

public class Leitura {
	Operacao op;
	LinkedList<Operacao> listaOperacoes = new LinkedList<>();

	public LinkedList<Operacao> ler(String Arquivo) throws SQLException, InterruptedException, ParseException {
		// vetores que recebem as coordenadas em double do arquivo
		BufferedReader percorreLinha = null; // buffer que le as linhas do arquivo todo
		String linha;
		String[] separador;
		boolean sangria = false;
		boolean recolhimento = false;
		Connection con = ConnectionFactory.recuperarConexao();

		try { // se der erro ja vai para os catchs de exceptions
			percorreLinha = new BufferedReader(new FileReader("./logArchive/" + Arquivo));
			System.out.println(Arquivo);
			linha = percorreLinha.readLine();

			while (percorreLinha.ready()) {
				linha = percorreLinha.readLine();
				while (linha.matches("\\s*"))
					linha = percorreLinha.readLine();

				Operacao op = new Operacao();

				if (linha.matches("DEPOSITO\\s*")) {
					op.setTipo("DEPOSITO");
				} else if (linha.matches("DEPOSITO SANGRIA\\s*")) {
					sangria = true;
					op.setTipo("DEPOSITO SANGRIA");
				} else if (linha.matches("RECOLHIMENTO\\s*")) {
					recolhimento = true;
					op.setTipo("RECOLHIMENTO");
				} else {
					while ((!(linha.contains("********")) && (linha = percorreLinha.readLine()) != null))
						;
					continue;
				}

				linha = percorreLinha.readLine();
				while (linha.matches("\\s*"))
					linha = percorreLinha.readLine();
				separador = linha.split("\\s+");
				op.setData(separador[1]);
				op.setHora(separador[3]);

				linha = percorreLinha.readLine();
				while (linha.matches("\\s*"))
					linha = percorreLinha.readLine();
				separador = linha.split("\\s+");
				op.setId_atm(Integer.parseInt(separador[2]));
				op.setSequencia(Integer.parseInt(separador[3].substring(separador[3].indexOf(":") + 1)));

				linha = percorreLinha.readLine();
				while (linha.matches("\\s*"))
					linha = percorreLinha.readLine();
				separador = linha.split("\\s+");
				op.setId_operador(Integer.parseInt(separador[2]));

				linha = percorreLinha.readLine();
				while (linha.matches("\\s*"))
					linha = percorreLinha.readLine();
				separador = linha.split("\\s+");
//				if (separador.length == 2)
//					op.setNome_operador(null);
				if (linha.contains("NOME OPERADOR")) {
					for (int i = 2; i < separador.length; i++) {
//						linha = percorreLinha.readLine();
//						separador = linha.split(":");
						op.setNome_operador(separador[i] + " ");
//						op.setNome_operador(separador[2] + " ");
					}
				} else if (separador.length == 2) {
					op.setNome_operador(null);
				} else {
//						linha = percorreLinha.readLine();
					separador = linha.split(":");
					op.setNome_operador(separador[1] + " ");

				}

				linha = percorreLinha.readLine();
				while (linha.matches("\\s*"))
					linha = percorreLinha.readLine();
				separador = linha.split("\\s+");
				if (separador.length == 2)
					op.setId_coleta(null);
				else
					op.setId_coleta(separador[2]);

				if (sangria) {
					sangria = false;
					linha = percorreLinha.readLine();
					while (linha.matches("\\s*"))
						linha = percorreLinha.readLine();
					separador = linha.split("\\s+");
					op.setId_sangria(Integer.parseInt(separador[2]));

					linha = percorreLinha.readLine();
					while (linha.matches("\\s*"))
						linha = percorreLinha.readLine();
					separador = linha.split("\\s+");
					op.setPdv(Integer.parseInt(separador[1]));
				}

				if (recolhimento) {
					recolhimento = false;
					linha = percorreLinha.readLine();
					while (linha.matches("\\s*"))
						linha = percorreLinha.readLine();
					separador = linha.split("\\s+");
					if (!separador[0].matches("CODIGO"))
						op.setCodigo_lacre((long) -1);
					else
						op.setCodigo_lacre(Long.parseLong(separador[3]));
				}

				while (!(linha.contains("VALOR DEPOSITADO") || linha.contains("VALORES VALIDADOS")
						|| linha.contains("TOTAL (A + B)")))
					linha = percorreLinha.readLine();
				if (linha.contains("VALOR DEPOSITADO")) {
					separador = linha.split("\\s+");
					separador = separador[2].split(",");
					op.setTotal(Integer.parseInt(separador[0]));

					linha = percorreLinha.readLine();
					while (!linha.contains("$"))
						linha = percorreLinha.readLine();

					for (int i = 0; i < 6; i++) {
						separador = linha.split("\\s+");
						op.setDenominacao(Integer.parseInt(separador[2]), i);
						linha = percorreLinha.readLine();
					}
				} else if (linha.contains("VALORES VALIDADOS")) {
					separador = linha.split("\\s+");
					separador = separador[3].split(",");
					op.setTotal(Integer.parseInt(separador[0]));

					linha = percorreLinha.readLine();
					while (!linha.contains("$"))
						linha = percorreLinha.readLine();

				} else if (linha.contains("TOTAL (A + B)")) {
					separador = linha.split("\\s+");
					separador = separador[4].split(",");
					op.setTotal(Integer.parseInt(separador[0].replace(".", "")));
				}

				Dao d = new Dao();
				d.gravarBanco(op, con);
				
				
				
				while ((!(linha.contains("********")) && (linha = percorreLinha.readLine()) != null)) {
				}

				listaOperacoes.add(op);
				
			}
		} catch (

		FileNotFoundException e) { // arquivo nao existente
			System.out.println("File Not Found Exception: \n" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) { // posicao invalida array
			System.out.println("Index Out Of Bounds Exception: \n" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Exception: \n" + e.getMessage());
		} finally {
			if (percorreLinha != null) {
				try {
					percorreLinha.close();
				} catch (IOException e) {
					System.out.println("IO Exception: \n" + e.getMessage());
				}
			}
		}
		return listaOperacoes;
	}
}
