package reciclarJa.controller;


import java.util.ArrayList;
import java.util.Scanner;

import reciclarJa.doacao.*;
import reciclarJa.model.Pessoa;
import reciclarJa.repository.ReciclarJaRepository;


public class ReciclarJaController implements ReciclarJaRepository {
	
	Scanner leia = new Scanner (System.in);
	campodoacao doacao =  new campodoacao();
	
	
	private ArrayList<Pessoa> listaClientes = new ArrayList<Pessoa>();
	int opcao;
	
	@Override// Localizar o CPF na ArrayList listaClientes
	public void procurarPorCpf(String cpf) {
		var pessoa = buscarNaCollection(cpf);
		
		if(pessoa != null) {
			pessoa.visualizar();
		//colocar aqui o uma mensagem de agradecimento por ter salvo os créditos
		} else {
			System.out.println("============================================================================================");
			System.out.println("||                                                                                        ||");                                                                                    
			System.out.println("||                            O CPF não possui cadastro!                                  ||"); 
			System.out.println("||           Para creditar, precisamos cadastrar seu CPF, deseja continuar?               ||");
			System.out.println("||                               (1) Sim    |    (2) Não                                  ||");
			System.out.println("||                                                                                        ||");
			System.out.println("============================================================================================");
			//lendo a opção
			opcao = leia.nextInt ();
		}
		
		switch (opcao) {
		//caso ele queira cadastrar: linkar aqui a parte de cadastro:
		case 1:
			break;
		//caso ele diga que não quer cadastrar:
		case 2:
		//vai aparecer a mensagem avisando que os valores vão ser doados e vai ler a resposta
			doacao.msgdoacao();
		//se a resposta for positiva ele vai doar e aparecer a mensagem de agradecimento
			doacao.doar(opcao);
		}
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
	public Pessoa buscarNaCollection (String cpf) {
		for (var pessoa:listaClientes) {
			if (pessoa.getCpf() == cpf) {
				return pessoa;		
			}		
		}
		return null;
	 }
	
}
	
