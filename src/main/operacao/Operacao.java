package main.operacao;

public class Operacao {
	
	int tipo;
	String data;
	String hora;
	int id_atm;
	int id_operador;
	int sequencia;
	String nome_operador = "";
	String id_coleta;
	int id_sangria = -1;
	int pdv = -1;
	int[] denominacao = new int[6];
	int total;
	double valorAB;
	Long codigo_lacre = (long) -1;
	

	
	public double getValorAB() {
		return valorAB;
	}
	public void setValorAB(double valorAB) {
		this.valorAB = valorAB;
	}
	
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
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
	
	
}
