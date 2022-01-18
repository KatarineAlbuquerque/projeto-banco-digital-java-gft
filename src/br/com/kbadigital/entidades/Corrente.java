package br.com.kbadigital.entidades;

public class Corrente extends Conta {

	private Integer idCorrente;

	public Corrente() {
		super();
	}

	public Corrente(Integer agencia, Integer numero, Cliente cliente, Integer idCorrente) {
		super(agencia, numero, cliente);
		this.idCorrente = idCorrente;
	}
	
	public Corrente(Integer agencia, Integer numero, Cliente cliente) {
		super(agencia, numero, cliente);
	}

	public Integer getIdCorrente() {
		return idCorrente;
	}

	public void setIdCorrente(Integer idCorrente) {
		this.idCorrente = idCorrente;
	}

	@Override
	public String toString() {
		return "Corrente [agencia ="+ agencia +" cliente=" + cliente.getNome() + " saldo=" + saldo + "]";
	}	
}
