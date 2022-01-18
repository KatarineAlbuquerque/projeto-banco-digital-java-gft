package br.com.kbadigital.entidades;

public class Poupanca extends Conta {
	
	private Integer idPoupanca;

	public Poupanca() {
		super();
	}

	public Poupanca(Integer agencia, Integer numero, Cliente cliente, Integer idPoupanca) {
		super(agencia, numero, cliente);
		this.idPoupanca = idPoupanca;
	}
	
	public Poupanca(Integer agencia, Integer numero, Cliente cliente) {
		super(agencia, numero, cliente);
	}

	public Integer getIdPoupanca() {
		return idPoupanca;
	}

	public void setIdPoupanca(Integer idPoupanca) {
		this.idPoupanca = idPoupanca;
	}

	@Override
	public String toString() {
		return "Poupanca [agencia ="+ agencia +" cliente=" + cliente.getNome() + " saldo=" + saldo + "]";
	}	
}
