package br.com.kbadigital.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.kbadigital.entidades.Cliente;
import br.com.kbadigital.entidades.Conta;
import br.com.kbadigital.entidades.Corrente;
import br.com.kbadigital.entidades.Poupanca;

public class Programa {

	public static void main(String[] args) {

		// Para fazer a leitura dos dados
		Scanner leitor = new Scanner(System.in);

		// Clientes
		Cliente cliente = null;

		// Contas
		Conta conta = new Conta();

		// Informa um número inteiro para contagem
		System.out.print("Quantidade de Contas: ");
		int quantidade = leitor.nextInt();

		// Faz a contagem de acordo com o solicitado em quantidade
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
			System.out.print("Agência: ");
			int agencia = leitor.nextInt();
			System.out.print("Conta: ");
			int numero = leitor.nextInt();

			// Cria Cliente
			cliente = new Cliente(nome, email);

			// Escolher uma opção entre Contas Corrente e Poupança
			System.out.println();
			System.out.println("Escolha uma Opção: ");
			System.out.print("[1]-Conta Corrente ou [2]-Conta Poupança: ");
			int escolha = leitor.nextInt();

			System.out.println();

			// Dizer uma quantidade de Movimentos a realizar (Saque, Depósito ou Transferência)
			System.out.print("Quantos movimentos deseja fazer: ");
			int movimento = leitor.nextInt();
			System.out.println();

			// Contador de quantidades de Movimentos
			for (int j = 0; j < movimento; j++) {

				// Escolher entre Saque, Depósito e Transferência
				System.out.println("Escolha uma Opção: ");
				System.out.print("[1]-Saque ou [2]-Depósito ou [3]-Transferência: ");
				int opcao = leitor.nextInt();

				// Faz o teste de acordo com o digitado
				switch (escolha) {
				case 1: { // Conta Corrente
					if (opcao == 1) { // Se saque faz
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
						} catch (InputMismatchException e) { // Erro ao digitar ponto no lugar de vírgula
							System.out.println("Digite o valor com vírgula! Ex: 100,00.");
						}

					} else if (opcao == 2) { // Se depósito faz
						try {
							System.out.print("Valor do Depósito: ");
							double valor = leitor.nextDouble();
							double calculo = conta.depositar(valor);
							conta = new Corrente(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Depósito: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) { // Erro ao digitar ponto no lugar de vírgula
							System.out.println("Digite o valor com vírgula! Ex: 100,00.");
						}
					} else if (opcao == 3) { // Se Transferência faz
						try {
							System.out.print("Valor do Transferência: ");
							double valor = leitor.nextDouble();
							double calculo = conta.transferir(valor);
							conta = new Corrente(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Transferência: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) { // Erro ao digitar ponto no lugar de vírgula
							System.out.println("Digite o valor com vírgula! Ex: 100,00.");
						}
					} else {
						System.out.println("Informe [1]-Saque ou [2]-Depósito ou [3]-Transferência.");						
					}
					break;
				}
				case 2: { // Conta Poupança
					if (opcao == 1) { // Se Saque faz
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
						} catch (InputMismatchException e) { // Erro ao digitar ponto no lugar de vírgula
							System.out.println("Digite o valor com vírgula! Ex: 100,00.");
						}

					} else if (opcao == 2) { // Se Depósito faz
						try {
							System.out.print("Valor do Depósito: ");
							double valor = leitor.nextDouble();
							double calculo = conta.depositar(valor);
							conta = new Poupanca(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Depósito: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) { // Erro ao digitar ponto no lugar de vírgula
							System.out.println("Digite o valor com vírgula! Ex: 100,00.");
						}
					} else if (opcao == 3) { // Se Transferência faz
						try {
							System.out.print("Valor do Transferência: ");
							double valor = leitor.nextDouble();
							double calculo = conta.transferir(valor);
							conta = new Poupanca(agencia, numero, cliente);
							conta.setSaldo(calculo);
							conta.exibirRecibo();
							System.out.printf("Transferência: %.2f%n",valor);
							cliente.adicionarConta(conta);
							System.out.println();
							break;
						} catch (InputMismatchException e) { // Erro ao digitar ponto no lugar de vírgula
							System.out.println("Digite o valor com vírgula! Ex: 100,00.");
						}
					} else {
						System.out.println("Informe [1]-Saque ou [2]-Depósito ou [3]-Transferência.");
					}
					break;
				}
				default: // Caso não satisfaça as opções acima
					System.out.println("Informe [1]-Conta Corrente ou [2]-Conta Poupança.");
				}
			}
			System.out.println();
		}		
		leitor.close(); // Finaliza o Scanner
	}
}
