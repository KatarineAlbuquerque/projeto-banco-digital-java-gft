package br.com.kbadigital.interfaces;

public interface Movimento {
	
	Double sacar(Double valor);
	Double depositar(Double valor);
	Double transferir(Double valor);
}
