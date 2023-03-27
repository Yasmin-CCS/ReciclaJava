package reciclarJa.controller;


import java.util.ArrayList;

import reciclarJa.model.Pessoa;
import reciclarJa.repository.ReciclarJaRepository;

public class ReciclarJaController implements ReciclarJaRepository {
	
	
	private ArrayList<Pessoa> listaClientes = new ArrayList<Pessoa>();

	@Override
	public void procurarPorCpf(String cpf) {
		var pessoa = buscarNaCollection(cpf);
		
		if(pessoa != null)
			pessoa.visualizar();
		else
			System.out.println("\n O CPF : "+cpf+" não possui cadastro! ");
		
	}

	@Override
	public void cadastrar(Pessoa pessoa) {
		listaClientes.add(pessoa);
		System.out.println("\n Cadastro feito com sucesso!");
		
	}

	@Override
	public void listarTodas() {
		for (var pessoa: listaClientes) {
			pessoa.visualizar();
		}
		
	}

	@Override
	public void sacar(float valor) {
		// TODO Auto-generated method stub
		
	}
	
	public Pessoa buscarNaCollection(String cpf) {
		for (var pessoa:listaClientes) {
			if (pessoa.getCpf() == cpf) {
				return pessoa;	
			}
		}
		return null;
		
	}

}
