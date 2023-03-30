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
			System.out.println("Cadastro não encontrado!");
			menu.casoCreditoNaoCpf(null, saldo, cpf, cpf);
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



}
