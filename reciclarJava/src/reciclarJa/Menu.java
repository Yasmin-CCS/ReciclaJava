package reciclarJa;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import reciclarJa.model.Material;
import reciclarJa.controller.ReciclarJaController;
import reciclarJa.model.Compra;
import reciclarJa.model.Pessoa;
import reciclarJa.util.Cores;

public class Menu {
	static ArrayList<Material> materiais = new ArrayList();
	static Scanner input = new Scanner(System.in);
	static ArrayList<Compra> compras = new ArrayList();
	static ReciclarJaController contas = new ReciclarJaController();
	static String cpf;
	static Material papel = new Material("Papel", (float) 0.05);
	static Material plastico = new Material("Plástico", (float) 0.10);
	static Material vidro = new Material("Vidro", (float) 0.15);
	static Material metal = new Material("Metal", (float) 0.20);

	public static void main(String[] args) {
		float novoSaldo = saldoSomaAnterior(saldoPessoa(0), 0);
		materiais.add(papel);
		materiais.add(plastico);
		materiais.add(vidro);
		materiais.add(metal);
		menuPrimario(input,novoSaldo);
	}

	public static float saldoPessoa(float saldo) {
		
		float saldoPessoa = saldo;
		return saldoPessoa;
	}
	public static float saldoSomaAnterior(float saldoPessoa,float saldo) {
		
		float saldoNovo = saldoPessoa + saldo;
		
		return saldoNovo;
	}

	public static String menuPrimario(Scanner input,float saldoNovo) {
		String nome = "";
		while (nome.isEmpty()) {
			System.out.println("\n" + Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + " ================================================================================");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                      Bem vinde ao ReciclarJá                               ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                    Por favor, qual o seu nome?                             ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||            Para o nome, por favor, utilizar apenas letras(A-Z)             ||");
			System.out.println(" ================================================================================" + Cores.TEXT_RESET);
			
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			nome = input.nextLine();
			System.out.println("" + Cores.TEXT_RESET);
		}

		menuMaterias(nome,saldoNovo);
		return nome;

	}

	public static int menuSecundário(Scanner input, String nome) {
		int opcao = 0;
		while (opcao != 1 && opcao != 2) {
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + " ================================================================================");
			System.out.println(" ||                                                                            ||");
			System.out
					.println("                   Obrigado por utilizar nosso programa " + nome + "                   ");
			System.out.println(" ||                 Por favor, escolha a opção que deseja ver:                 ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                  (1) Deseja ver seus créditos?                             ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                  (2) Deseja reciclar algum material?                       ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                    Entre com a opção desejada                              ||");
			System.out.println(" ||============================================================================||");
			try {
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
				opcao = input.nextInt();
				System.out.println("" + Cores.TEXT_RESET);
			} catch (InputMismatchException e) {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED + "Por favor, digite números inteiros! ");
				input.nextLine();
				opcao = 0;
			}
			if (opcao == 1 || opcao == 2) {
				System.out.println("Redirecionando...");
			} else {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED + "A opção não existe, por favor, selecione uma opção válida!");
			}

		}
		return opcao;
	}

	public static void menuCredito(int opcao, String nome,float saldo) {
		if (opcao == 1) {
			System.out.println("Olá, " + nome);
			System.out.println("Digite o cpf: ");
			input.nextLine();
			input.skip("\\R?");
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			cpf = input.nextLine();
			System.out.println("" + Cores.TEXT_RESET);
			contas.procurarPorCpf(cpf,saldo);

		}
		keyPress();
	}

	public static float menuMaterias(String nome,float saldoNovo) {
		int escolha = 0;
		float saldo = 0;
		// if (opcao == 2) {
		while (escolha < 1 || escolha > 6) {
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + " ================================================================================");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out
					.println(" ||                          Bem vinde ao ReciclarJá, " + nome + "                     ||");
			System.out.println(" ||                             Menu de Materiais                              ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                  (1) Papel       ||        (2) Plástico                    ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                  (3) Vidro       ||        (4) Metal                       ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                          Digite a opção desejada :                         ||");
			System.out.println(" ================================================================================" + Cores.TEXT_RESET);
			try {
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
				escolha = input.nextInt();
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			} catch (InputMismatchException e) {
				digiteNumeros();
				input.nextLine();
				escolha = 0;
			}
			if (escolha < 1 || escolha > 4) {
				naoValido();
			} else {
				materiais.get(escolha - 1).visualizar();
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "Qual o peso que deseja reciclar? "+ Cores.TEXT_RESET);
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
				float peso = input.nextFloat();
				System.out.println("" + Cores.TEXT_RESET);
				Compra novaCompra = new Compra(materiais.get(escolha - 1), peso);
				saldo += novaCompra.valorCompra();
				compras.add(novaCompra);
				novaCompra.valorCompra();
			}

		}
		menuAdicionar(nome, saldo,saldoNovo);
		keyPress();
		return saldo;
	}

	public static void menuAdicionar(String nome, float saldo,float saldoNovo) {
		int escolher = 0;
		
		while(escolher != 1 && escolher != 2 && escolher != 3) {
			
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "=======================================================");
		System.out.println("||                                                   ||");
		System.out.println("||       (1) Continuar adicionando materiais         ||");
		System.out.println("||       (2) Encerrar adição de materiais            ||");
		System.out.println("||       (3) Deseja doar ou creditar                 ||");
		System.out.println("||                                                   ||");
		System.out.println("=======================================================" + Cores.TEXT_RESET);
		try {
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			escolher = input.nextInt();
			System.out.println("" + Cores.TEXT_RESET);
		} catch (InputMismatchException e) {
			digiteNumeros();
			input.nextLine();
			escolher = 0;
		}
		if (escolher == 1) {
			menuMaterias(nome,saldoNovo);
		} else if (escolher == 2) {
			input.close();
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND +"============================================================");
			System.out.println("||                                                        ||");
			System.out.println("||        A ReciclarJá agradece sua participação          ||");
			System.out.println("||                                                        ||");
			System.out.println("============================================================" + Cores.TEXT_RESET);
			System.exit(0);
		} else if (escolher == 3) {
			qtdCreditos(saldo, nome,saldoNovo);
		} else {
			naoValido();
		}
		}
	}

	public static void menuDoacao(float saldo, String nome,float saldoNovo) {
		int validacao = 0;
		while(validacao != 1 && validacao != 2) {
			
		
		System.out.println(
				Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "===============================================================================================================================");
		System.out.println(
				"||                                                                                                                           ||");
		System.out.println(
				"||     Os créditos serão doados para projetos que incentivam o plantio de árvores na Amazonia, deseja continuar?             ||");
		System.out.println(
				"||                                      (1) - Sim |  (2) - Não                                                               ||");
		System.out.println(
				"||                                                                                                                           ||");
		System.out.println(
				"===============================================================================================================================" + Cores.TEXT_RESET);
		try {
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
			validacao = input.nextInt();
			System.out.println("" + Cores.TEXT_RESET);
		} catch (InputMismatchException e) {
			digiteNumeros();
			input.nextLine();
			validacao = 0;
		}
		if (validacao == 1) {
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "============================================================");
			System.out.println("||                                                        ||");
			System.out.println("||         A Recicle já agradece a sua doação!            ||");
			System.out.println("            O valor doado foi de: " + saldo + "                       ");
			System.out.println("||                                                        ||");
			System.out.println("============================================================" + Cores.TEXT_RESET);
			keyPress();
			input.close();
			System.exit(0);
		} else if (validacao == 2) {
			menuAdicionar(nome, saldo,saldoNovo);
		}
		}
	}

	public static void qtdCreditos(float saldo, String nome,float saldoNovo) {
		int escolha = 0;
		
		while (escolha != 1 && escolha != 2 ) {
			
		
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "=======================================================");
		System.out.println("||                                                   ||");
		System.out.println("||         Quantidade de créditos: " + saldo + "               ||");
		System.out.println("||   (1) Doar       //      (2) Creditar na conta   ||");
		System.out.println("||                                                   ||");
		System.out.println("=======================================================" + Cores.TEXT_RESET);
		try {
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			escolha = input.nextInt();
			System.out.println("" + Cores.TEXT_RESET);
		} catch (InputMismatchException e) {
			digiteNumeros();
			input.nextLine();
			escolha = 0;
		}
		if (escolha == 1) {
			menuDoacao(saldo, nome,saldoNovo);
		} else if (escolha == 2) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "Digite seu CPF: " + Cores.TEXT_RESET);
			input.nextLine();
			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND  + Cores.TEXT_YELLOW);
			cpf = input.nextLine();
			System.out.println("" + Cores.TEXT_RESET);
			Pessoa pessoa = contas.buscarNaCollection(cpf);
			if (pessoa != null) {
				System.out.println(saldoNovo);
			}else {
				contas.casoCreditoNaoCpf(pessoa,saldo);
				
			}
		} else {
			naoValido();
		}
		}
	}

	public static void digiteNumeros() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED + "\nPor favor, digite números inteiros! \n" + Cores.TEXT_RESET);
	}

	public static void naoValido() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED + "Opção inválida, por favor, digite novamente \n" + Cores.TEXT_RESET);
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "\nPressione Enter para continuar... " + Cores.TEXT_RESET);
			System.in.read();
		} catch (IOException e) {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED + "Você pressionou uma tecla diferente de Enter!" + Cores.TEXT_RESET);
		}
	}

}
