package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import main.leitura.TransformaParaTexto;

public class MainRegex {

	public static void main(String[] args) {
		Matcher matcher;
		
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get("0001_        00000016_05122019010004.EJMC"),
//		try (Stream<String> stream = Files.lines(Paths.get("0001_0000000000000001_1501020010005.EJMC"),
				StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String dep_sangria =  "(\\n)(DEPOSITO SANGRIA\\n)(.*?\\n)" 
				+ "(DATA:.*?)(\\w+/\\w+/\\w.*?)"
				+ "(HORA:.*?)(\\w+:\\w+)(.*?\\n)" 
				+ "(ID ATM:.*?)(\\w+.*?)" 
				+ "(SEQUENCIA:.*?)(\\w+)(.*?\\n)"
				+ "(ID OPERADOR:.*?)(\\w+)(.*?\\n)" 
				+ "(NOME OPERADOR:.*?)(.*?)(\\n.*\\n)"
				+ "(ID COLETA:.*?)(\\w+)(.*\\n)"
				+ "(ID SANGRIA:.*?)(\\w+)(.*\\n)"
				+ "(PDV:.*?)(\\w+)((.|\\n)*?)"
				+ "(VALOR DEPOSITADO:.*?)(\\w+)";

		String dep = "(\\n)(DEPOSITO\\n)(.*?\\n)" 
				+ "(DATA:.*?)(\\w+/\\w+/\\w.*?)"
				+ "(HORA:.*?)(\\w+:\\w+)(.*?\\n)" 
				+ "(ID ATM:.*?)(\\w+.*?)" 
				+ "(SEQUENCIA:.*?)(\\w+)(.*?\\n)"
				+ "(ID OPERADOR:.*?)(\\w+)(.*?\\n)" 
				+ "(NOME OPERADOR:.*?)(.*?)(\\n.*\\n)"
				+ "(ID COLETA:.*?)(\\w+)((.|\\n)*?)"
				+ "(VALOR DEPOSITADO:.*?)(\\w+)";
		
		String recolhimento = "(\\n)(RECOLHIMENTO.*?\\n)(.*?\\n)" 
				+ "(DATA:.*?)(\\w+/\\w+/\\w.*?)"
				+ "(HORA:.*?)(\\w+:\\w+)(.*?\\n)" 
				+ "(ID ATM:.*?)(\\w+.*?)" 
				+ "(SEQUENCIA:.*?)(\\w+)(.*?\\n)"
				+ "(ID OPERADOR:.*?)(\\w+)(.*?\\n)" 
				+ "(NOME OPERADOR: .*?)(.*?)(\\n.*\\n)"
				+ "(ID COLETA:.*?)(\\w+)(.*?\\n.*?\\n)" 
				+ "(CODIGO DO LACRE:.*?)(\\w+)((.|\\n)*?)"
				+ "(TOTAL DEPOSITADO.*?\\(V\\):.*?)(\\w+)";
//		TransformaParaTexto.returnDataDeposito(dep, contentBuilder.toString());
//		TransformaParaTexto.returnDataSangria(dep_sangria, contentBuilder.toString());
		TransformaParaTexto.returnDataRecolhimento(recolhimento, contentBuilder.toString());



	}

}
