package reciclarJa.controller;


import java.util.ArrayList;

import reciclarJa.model.Pessoa;
import reciclarJa.repository.ReciclarJaRepository;

public class ReciclarJaController implements ReciclarJaRepository {
	
	
	private ArrayList<Pessoa> listaClientes = new ArrayList<Pessoa>();

	@Override// Localizar o CPF na ArrayList listaClientes
	public void procurarPorCpf(String cpf) {
		var pessoa = buscarNaCollection(cpf);
		
		if(pessoa != null)
			pessoa.visualizar();
		else
			System.out.println("\n O CPF : "+cpf+" não possui cadastro! ");
		
	}

	@Override // Método para puxar o cadastro
	public void cadastrar(Pessoa pessoa) {
		listaClientes.add(pessoa);
		System.out.println("\n Cadastro feito com sucesso!");
		
	}

	@Override // Listar todos os clientes
	public void listarTodas() {
		for (var pessoa: listaClientes) {
			pessoa.visualizar();
		}
		
	}

	// Buscar cliente na ArrayList ListaClientes
	public Pessoa buscarNaCollection(String cpf) {
		for (var pessoa:listaClientes) {
			if (pessoa.getCpf() == cpf) {
				return pessoa;	
			}
		}
		return null;
		
	}

}
