package reciclarJa.controller;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;
import reciclarJa.model.Pessoa;
import reciclarJa.repository.ReciclarJaRepository;
import reciclarJa.util.Cores;
import reciclarJa.Menu;

public class ReciclarJaController implements ReciclarJaRepository {
	String nome;
	Menu menu = new Menu();
	Scanner leia = new Scanner(System.in);
	String cpf;

	private ArrayList<Pessoa> listaClientes = new ArrayList<Pessoa>();;

	// ler o cpf para validar
	public String lerCpf() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "Digite seu CPF: " + Cores.TEXT_RESET);
		System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
		cpf = leia.nextLine();
		System.out.println("" + Cores.TEXT_RESET);
		while (validarCpf() == false) {
			System.out.println("CPF inválido!! Digite novamente: ");
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			cpf = leia.nextLine();
			System.out.println("" + Cores.TEXT_RESET);

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
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "\n Cadastro feito com sucesso! \n" + Cores.TEXT_RESET);

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
		while(opcao != 1 && opcao != 2) {
			
		
		System.out.println(
				Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "============================================================================================");
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
				"============================================================================================"+ Cores.TEXT_RESET);
		try {
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			opcao = leia.nextInt();
			System.out.println("" + Cores.TEXT_RESET);
		} catch (InputMismatchException e) {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + "\nPor favor, digite números inteiros! \n" + Cores.TEXT_RESET);
			leia.nextLine();
			opcao = 0;
		}

		if (opcao == 1) {
			cadastroPessoa(pessoa, saldo);
		} else if (opcao == 2) {
			menu.menuDoacao(saldo, nome, saldo);
			return;
		} else {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + "Opção inválida" + Cores.TEXT_RESET);
		}
		}
	}

	public void cadastroPessoa(Pessoa pessoa, float saldo) {
		float novoSaldo = 0;
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE +"Digite seu nome : " + Cores.TEXT_RESET);
		leia.nextLine();
		System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
		String nome = leia.nextLine();
		System.out.println("" + Cores.TEXT_RESET);
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE +"Digite seu cpf :"+ Cores.TEXT_RESET);
		System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
		leia.nextLine();
		String cpf = leia.nextLine();
		System.out.println("" + Cores.TEXT_RESET);
		pessoa = new Pessoa(nome, cpf, menu.saldoPessoa(saldo));	
		cadastrar(pessoa);
		menu.menuMaterias(nome,novoSaldo);
		// TODO levar para a próxima tela...
	}

}
