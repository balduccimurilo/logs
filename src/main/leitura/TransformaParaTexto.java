package main.leitura;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TransformaParaTexto {
	public static Matcher matcher;

	public static void returnDataSangria(String transaction, String contentBuilder) {
		Pattern dep_sangria_read = Pattern.compile(transaction);
		matcher = dep_sangria_read.matcher(contentBuilder);

		while (matcher.find()) {
			System.out.println("TRANSAÇÃO: " + matcher.group(2));
			System.out.println("DATA: " + matcher.group(5));
			System.out.println("HORA: " + matcher.group(7));
			System.out.println("ID ATM: " + matcher.group(10));
			System.out.println("SEQUENCIA: " + matcher.group(12));
			System.out.println("ID OPERADOR: " + matcher.group(15));
			System.out.println("NOME OPERADOR: " + matcher.group(18));
			System.out.println("ID COLETA: " + matcher.group(21));
			System.out.println("ID SANGRIA: " + matcher.group(24));
			System.out.println("PDV: " + matcher.group(27));
			System.out.println("VALOR DEPOSITADO: " + matcher.group(31));
			System.out.println();
		}
	}

	public static void returnDataDeposito(String transaction, String contentBuilder) {

		Pattern dep_reader = Pattern.compile(transaction);
		matcher = dep_reader.matcher(contentBuilder);

		while (matcher.find()) {
			System.out.println("TRANSAÇÃO: " + matcher.group(2));
			System.out.println("DATA: " + matcher.group(5));
			System.out.println("HORA: " + matcher.group(7));
			System.out.println("ID ATM: " + matcher.group(10));
			System.out.println("SEQUENCIA: " + matcher.group(12));
			System.out.println("ID OPERADOR: " + matcher.group(15));
			System.out.println("NOME OPERADOR: " + matcher.group(18));
			System.out.println("ID COLETA: " + matcher.group(21));
			System.out.println("VALOR DEPOSITADO: " + matcher.group(25));
			System.out.println();
		}
	}

	public static void returnDataRecolhimento(String transaction, String contentBuilder) {

		Pattern dep_sangria_read = Pattern.compile(transaction);
		matcher = dep_sangria_read.matcher(contentBuilder);

		while (matcher.find()) {
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(5));
			System.out.println(matcher.group(7));
			System.out.println(matcher.group(10));
			System.out.println(matcher.group(12));
			System.out.println(matcher.group(15));
			System.out.println(matcher.group(18));
			System.out.println(matcher.group(21));
			System.out.println(matcher.group(24));
			System.out.println(matcher.group(28));
		}
	}
}
