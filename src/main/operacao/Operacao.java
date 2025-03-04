package main.operacao;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Operacao {
	
	String tipo;
	String data;
	String hora;
	int id_atm;
	int id_operador;
	int sequencia;
	String nome_operador = "";
	String id_coleta;
	int id_sangria = 0;
	int pdv = 0;
	int[] denominacao = new int[6];
	int total;
	double valorAB;
	Long codigo_lacre = (long) 0;
	

	
	public double getValorAB() {
		return valorAB;
	}
	public void setValorAB(double valorAB) {
		this.valorAB = valorAB;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String string) {
		this.tipo = string;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getId_atm() {
		return id_atm;
	}
	public void setId_atm(int id_atm) {
		this.id_atm = id_atm;
	}
	public int getId_operador() {
		return id_operador;
	}
	public void setId_operador(int id_operador) {
		this.id_operador = id_operador;
	}
	public int getSequencia() {
		return sequencia;
	}
	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}
	public String getNome_operador() {
		return nome_operador;
	}
	public void setNome_operador(String nome_operador) {
		this.nome_operador += nome_operador;
	}
	public String getId_coleta() {
		return id_coleta;
	}
	public void setId_coleta(String id_coleta) {
		this.id_coleta = id_coleta;
	}
	public int getId_sangria() {
		return id_sangria;
	}
	public void setId_sangria(int id_sangria) {
		this.id_sangria = id_sangria;
	}
	public int getPdv() {
		return pdv;
	}
	public void setPdv(int pdv) {
		this.pdv = pdv;
	}
	
	public int getDenominacao(int index) {
		return this.denominacao[index];
	}
	
	public void setDenominacao(int qtdNota, int index) {
		this.denominacao[index] = qtdNota;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Long getCodigo_lacre() {
		return codigo_lacre;
	}
	public void setCodigo_lacre(Long codigo_lacre) {
		this.codigo_lacre = codigo_lacre;
	}
	

	
	@Override
	public String toString() {
		return "Operacao [tipo=" + tipo + ", data=" + data + ", hora=" + hora + ", id_atm=" + id_atm + ", id_operador="
				+ id_operador + ", sequencia=" + sequencia + ", nome_operador=" + nome_operador + ", id_coleta="
				+ id_coleta + ", id_sangria=" + id_sangria + ", pdv=" + pdv + ", denominacao="
				+ Arrays.toString(denominacao) + ", total=" + total + ", valorAB=" + valorAB + ", codigo_lacre="
				+ codigo_lacre + "]";
	}
	
	
	
	
}
