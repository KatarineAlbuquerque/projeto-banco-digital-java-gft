package br.com.kbadigital.entidades;

import br.com.kbadigital.interfaces.Movimento;

public class Conta implements Movimento {
	private Integer id;
	protected Integer agencia;
	private Integer numero;
	protected Double saldo;
	protected Cliente cliente;

	public Conta() {
		super();
	}

	public Conta(Integer id, Integer agencia, Integer numero, Cliente cliente) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
	}

	public Conta(Integer agencia, Integer numero, Cliente cliente) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Double sacar(Double valor) {
		if (valor < saldo) {
			return this.saldo -= valor;
		} else {
			System.out.println("Saldo maior do que o disponível!");
		}
		return 0.0;
	}

	@Override
	public Double depositar(Double valor) {
		this.saldo = 0.0;
		return this.saldo += valor;
	}

	@Override
	public Double transferir(Double valor) {		
		return this.sacar(valor);
	}

	public void exibirRecibo() {
		System.out.println();
		System.out.println("Banco Digital");
		System.out.println("-------------");
		System.out.println("Cliente : " + cliente.getNome());
		System.out.println("Agência: " + agencia + " Conta: " + numero);
		System.out.printf("Saldo: %.2f%n", getSaldo());
	}
}
