package reciclarJa.controller;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;
import reciclarJa.model.Pessoa;
import reciclarJa.repository.ReciclarJaRepository;
import reciclarJa.Menu;

public class ReciclarJaController implements ReciclarJaRepository {
	String nome;
	Menu menu = new Menu();
	Scanner leia = new Scanner(System.in);
	String cpf;

	private ArrayList<Pessoa> listaClientes = new ArrayList<Pessoa>();;

	// ler o cpf para validar
	public String lerCpf() {
		System.out.println("Digite seu CPF: ");
		cpf = leia.nextLine();
		while (validarCpf() == false) {
			System.out.println("CPF inválido!! Digite novamente: ");
			cpf = leia.nextLine();

		}
		return cpf;
	}

	public boolean validarCpf() {
		if (cpf.length() != 11) {
			return false;
		}
		return true;
	}

	@Override // Localizar o CPF na ArrayList listaClientes
	public void procurarPorCpf(String cpf, float saldo) {
		var pessoa = buscarNaCollection(cpf);

		int opcao = 0;
		if (pessoa != null) {
			pessoa.visualizar();
		} else {
			casoCreditoNaoCpf(pessoa, saldo);
		}
	}

	@Override // Método para puxar o cadastro
	public void cadastrar(Pessoa pessoa) {
		listaClientes.add(pessoa);
		System.out.println("\n Cadastro feito com sucesso!");

	}

	@Override // Listar todos os clientes
	public void listarTodas() {
		for (var pessoa : listaClientes) {
			pessoa.visualizar();
		}

	}

	// Buscar cliente na ArrayList ListaClientes
	public Pessoa buscarNaCollection(String cpf) {
		for (var pessoa : listaClientes) {
			if (pessoa.getCpf().equals(cpf)) {
				return pessoa;
			}
		}
		return null;
	}

	public void naoDoar(int validacao, String nome,float saldo) {
		menu.menuCredito(validacao, nome,saldo);
	}

	public void casoCreditoNaoCpf(Pessoa pessoa, float saldo) {
		int opcao = 0;

		System.out.println(
				"============================================================================================");
		System.out.println(
				"||                                                                                        ||");
		System.out.println(
				"||                            O CPF não possui cadastro!                                  ||");
		System.out.println(
				"||           Para creditar, precisamos cadastrar seu CPF, deseja continuar?               ||");
		System.out.println(
				"||                               (1) Sim    |    (2) Não                                  ||");
		System.out.println(
				"||                                                                                        ||");
		System.out.println(
				"============================================================================================");
		try {
			opcao = leia.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Por favor, digite números inteiros! ");
			leia.nextLine();
			opcao = 0;
		}

		if (opcao == 1) {
			cadastroPessoa(pessoa, saldo);
		} else if (opcao == 2) {
			return;
		} else {
			System.out.println("Opção inválida");
		}

	}

	public void cadastroPessoa(Pessoa pessoa, float saldo) {
		float novoSaldo = 0;
		System.out.println("Digite seu nome : ");
		leia.nextLine();
		String nome = leia.nextLine();
		System.out.println("Digite seu cpf :");
		leia.nextLine();
		String cpf = leia.nextLine();
		pessoa = new Pessoa(nome, cpf, menu.saldoPessoa(saldo));	
		cadastrar(pessoa);
		menu.menuMaterias(nome,novoSaldo);
		// TODO levar para a próxima tela...
	}

}
