package reciclarJa.controller;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;
import reciclarJa.model.Cliente;
import reciclarJa.repository.ReciclarJaRepository;
import reciclarJa.util.Cores;
import reciclarJa.Menu;

public class Pessoas implements ReciclarJaRepository {
	String nome;
	Scanner leia = new Scanner(System.in);
	String cpf;

	private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();;

	public boolean validarCpf(String cpf) {
		while (cpf.length() != 11) {
			return false;
		}
		return true;
	}

	@Override // Método para puxar o cadastro
	public void cadastrar(Cliente pessoa) {
		listaClientes.add(pessoa);
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "\n Cadastro feito com sucesso! \n"
				+ Cores.TEXT_RESET);

	}

	@Override // Listar todos os clientes
	public void listarTodas() {
		for (var pessoa : listaClientes) {
			pessoa.visualizar();
		}

	}

	// Buscar cliente na ArrayList ListaClientes
	public Cliente buscarNaCollection(String cpf) {
		for (var pessoa : listaClientes) {
			if (pessoa.getCpf().equals(cpf)) {
				return pessoa;
			}
		}
		return null;
	}

}
