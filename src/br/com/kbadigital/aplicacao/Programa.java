package br.com.kbadigital.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.kbadigital.entidades.Cliente;
import br.com.kbadigital.entidades.Conta;
import br.com.kbadigital.entidades.Corrente;
import br.com.kbadigital.entidades.Poupanca;

public class Programa {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);

		// Clientes
		Cliente cliente = null;

		// Contas
		Conta conta = new Conta();

		System.out.print("Quantidade de Contas: ");
		int quantidade = leitor.nextInt();

		for (int i = 0; i < quantidade; i++) {

			// Cliente
			System.out.print("Primeiro Nome: ");
			String primeiroNome = leitor.next();
			System.out.print("Sobremome: ");
			String segundoNome = leitor.next();
			String nome = primeiroNome + " " + segundoNome;
			System.out.print("Email: ");
			String email = leitor.next();

			// Contas
			System.out.print("Ag�ncia: ");
			int agencia = leitor.nextInt();
			System.out.print("Conta: ");
			int numero = leitor.nextInt();

			cliente = new Cliente(nome, email);

			System.out.println();
			System.out.println("Escolha uma Op��o: ");
			System.out.print("[1]-Corrente ou [2]-Poupan�a: ");
			int escolha = leitor.nextInt();

			System.out.println();

			System.out.print("Quantos movimentos deseja fazer: ");
			int movimento = leitor.nextInt();
			System.out.println();

			for (int j = 0; j < movimento; j++) {

				System.out.println("Escolha uma Op��o: ");
				System.out.print("[1]-Saque ou [2]-Dep�sito ou [3]-Transfer�ncia: ");
				int opcao = leitor.nextInt();

				switch (escolha) {
				case 1: {
					if (opcao == 1) {
						try {
							System.out.print("Valor do Saque: ");
							double valor = leitor.nextDouble();
							double calculo = conta.sacar(valor);
							conta = new Corrente(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Saque: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Digite o valor com v�rgula! Ex: 100,00.");
						}

					} else if (opcao == 2) {
						try {
							System.out.print("Valor do Dep�sito: ");
							double valor = leitor.nextDouble();
							double calculo = conta.depositar(valor);
							conta = new Corrente(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Dep�sito: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Digite o valor com v�rgula! Ex: 100,00.");
						}
					} else if (opcao == 3) {
						try {
							System.out.print("Valor do Transfer�ncia: ");
							double valor = leitor.nextDouble();
							double calculo = conta.transferir(valor);
							conta = new Corrente(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Transfer�ncia: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Digite o valor com v�rgula! Ex: 100,00.");
						}
					} else {
						System.out.println("Informe [1]-Saque ou [2]-Dep�sito ou [3]-Transfer�ncia.");						
					}
					break;
				}
				case 2: {
					if (opcao == 1) {
						try {
							System.out.print("Valor do Saque: ");
							double valor = leitor.nextDouble();
							double calculo = conta.sacar(valor);
							conta = new Poupanca(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Saque: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Digite o valor com v�rgula! Ex: 100,00.");
						}

					} else if (opcao == 2) {
						try {
							System.out.print("Valor do Dep�sito: ");
							double valor = leitor.nextDouble();
							double calculo = conta.depositar(valor);
							conta = new Poupanca(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Dep�sito: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Digite o valor com v�rgula! Ex: 100,00.");
						}
					} else if (opcao == 3) {
						try {
							System.out.print("Valor do Transfer�ncia: ");
							double valor = leitor.nextDouble();
							double calculo = conta.transferir(valor);
							conta = new Poupanca(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Transfer�ncia: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) {
							System.out.println("Digite o valor com v�rgula! Ex: 100,00.");
						}
					} else {
						System.out.println("Informe [1]-Saque ou [2]-Dep�sito ou [3]-Transfer�ncia.");
					}
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + escolha);
				}
			}
			System.out.println();
		}		
		leitor.close();
	}
}
