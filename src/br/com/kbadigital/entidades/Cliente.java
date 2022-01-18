package br.com.kbadigital.entidades;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private Integer id;
	private String nome;
	private String email;
	
	private List<Conta> contas = new ArrayList<>();
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public Cliente(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public void adicionarConta(Conta conta) {
		this.contas.add(conta);
	}	

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", email=" + email + "]";
	}
}
