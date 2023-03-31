package reciclarJa;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

import reciclarJa.model.Material;
import reciclarJa.controller.Pessoas;
import reciclarJa.model.Compra;
import reciclarJa.model.Cliente;
import reciclarJa.util.Cores;

public class Menu {
	static ArrayList<Material> materiais = new ArrayList<Material>();
	static Scanner input = new Scanner(System.in);
	static ArrayList<Compra> compras = new ArrayList<Compra>();
	static Pessoas pessoas = new Pessoas();

	public static void main(String[] args) {
		adicionarMateriais();
		Cliente cliente = cadastrarCliente();
		menuPrincipal(cliente);
	}

	private static Cliente cadastrarCliente() {
		String nome, cpf;
		cpf = lerCpf();
		Cliente pessoa = pessoas.buscarNaCollection(cpf);
		if (Objects.isNull(pessoa)) {
			nome = lerNome();
			pessoa = new Cliente(nome, cpf, 0);
			pessoas.cadastrar(pessoa);
			return pessoa;
		}
		return pessoa;
	}

	private static String lerNome() {
		String nome = "";
		while (nome.isEmpty()) {
			System.out.println("\n" + Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ " ================================================================================");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                    Por favor, qual o seu nome?                             ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||            Para o nome, por favor, utilizar apenas letras(A-Z)             ||");
			System.out.println(" ================================================================================"
					+ Cores.TEXT_RESET);

			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
			nome = input.nextLine();
			System.out.println("" + Cores.TEXT_RESET);
		}
		return nome;
	}

	private static String lerCpf() {
		String cpf = "";
		while (cpf.isEmpty()) {
			System.out.println("\n" + Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ " ================================================================================");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                      Bem vinde ao ReciclarJá                               ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                    Por favor, qual o seu CPF?                              ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                      Digite o CPF, por favor                               ||");
			System.out.println(" ================================================================================"
					+ Cores.TEXT_RESET);

			System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
			cpf = input.nextLine();
			System.out.println("" + Cores.TEXT_RESET);
		}
		return cpf;
	}

	public static void adicionarMateriais() {
		Material papel = new Material("Papel", (float) 0.5);
		Material plastico = new Material("Plástico", (float) 0.15);
		Material vidro = new Material("Vidro", (float) 0.12);
		Material metal = new Material("Metal", (float) 6.00);
		materiais.add(papel);
		materiais.add(plastico);
		materiais.add(vidro);
		materiais.add(metal);
	}

	public static void menuPrincipal(Cliente cliente) {
		int escolher = 0;

		while (escolher != 1 && escolher != 2 && escolher != 3 && escolher != 4) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ "=======================================================");
			System.out.println("||                                                   ||");
			System.out.println("||          Seja Bem Vinde ao RecilarJá              ||");
			System.out.println("||             " + cliente.getNome() + "               ||");
			System.out.println("||                                                   ||");
			System.out.println("=======================================================");
			System.out.println("||       (1) Vender seus recicláveis                 ||");
			System.out.println("||       (2) Deseja doar                             ||");
			System.out.println("||       (3) Visualizar conta                        ||");
			System.out.println("||       (4) Encerrar programa                       ||");
			System.out.println("=======================================================");
			System.out.println("||           Escolha a opção desejada:               ||");
			System.out.println("=======================================================" + Cores.TEXT_RESET);
			try {
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
				escolher = input.nextInt();
				System.out.println("" + Cores.TEXT_RESET);
			} catch (InputMismatchException e) {
				digiteNumeros();
				input.nextLine();
				escolher = 0;
			}
			if (escolher == 1) {
				menuMaterias(cliente);
			} else if (escolher == 2) {
				menuParaDoar(cliente);
			} else if (escolher == 3) {
				visualizarContas(cliente);
			} else if (escolher == 4) {
				input.close();
				System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
						+ "============================================================");
				System.out.println("||                                                        ||");
				System.out.println("||        A ReciclarJá agradece sua participação          ||");
				System.out.println("||                                                        ||");
				System.out.println("============================================================" + Cores.TEXT_RESET);
				System.exit(0);
			} else {
				naoValido();
			}
		}
	}

	public static void menuMaterias(Cliente cliente) {
		int escolha = 0;
		while (escolha < 1 || escolha > 4) {
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ " ================================================================================");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                          Bem vinde ao ReciclarJá, " + cliente.getNome()
					+ "                     ||");
			System.out.println(" ||                             Menu de Materiais                              ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                  (1) Papel       ||        (2) Plástico                    ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                  (3) Vidro       ||        (4) Metal                       ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                          Digite a opção desejada :                         ||");
			System.out.println(" ================================================================================"
					+ Cores.TEXT_RESET);
			try {
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
				escolha = input.nextInt();
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
			} catch (InputMismatchException e) {
				digiteNumeros();
				input.nextLine();
				escolha = 0;
			}
			if (escolha < 1 || escolha > 4) {
				naoValido();
			} else {
				materiais.get(escolha - 1).visualizar();
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "Qual o peso que deseja reciclar? "
						+ Cores.TEXT_RESET);
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
				float peso = input.nextFloat();
				System.out.println("" + Cores.TEXT_RESET);
				Compra novaCompra = new Compra(materiais.get(escolha - 1), peso);
				cliente.setSaldo(cliente.getSaldo() + novaCompra.valorCompra());
				novaCompra.ver();
			}

		}
		menuPrincipal(cliente);
		keyPress();
	}

	public static void menuParaDoar(Cliente cliente) {
		int escolha = 0;
		String cpf = "";
		while (escolha != 1 && escolha != 2) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ "=======================================================");
			System.out.println("||                                                   ||");
			System.out.println("||         Quantidade de créditos: " + cliente.getSaldo() + "               ||");
			System.out.println("||        (1) Doar           // (2) Deseja voltar?   ||");
			System.out.println("||                                                   ||");
			System.out.println("=======================================================" + Cores.TEXT_RESET);
			try {
				System.out.println("" + Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_YELLOW);
				escolha = input.nextInt();
				System.out.println("" + Cores.TEXT_RESET);
			} catch (InputMismatchException e) {
				digiteNumeros();
				input.nextLine();
				escolha = 0;
			}
			if (escolha == 1) {
				menuDoacao(cliente);
			} else if (escolha == 2) {
				menuPrincipal(cliente);
			} else {
				naoValido();
			}
		}
	}

	public static void menuDoacao(Cliente cliente) {
		int validacao = 0;
		while (validacao != 1 && validacao != 2) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ "===============================================================================================================================");
			System.out.println(
					"||                                                                                                                           ||");
			System.out.println(
					"||     Os créditos serão doados para projetos que incentivam o plantio de árvores na Amazonia, deseja continuar?             ||");
			System.out.println(
					"||                                      (1) - Sim |  (2) - Não                                                               ||");
			System.out.println(
					"||                                                                                                                           ||");
			System.out.println(
					"==============================================================================================================================="
							+ Cores.TEXT_RESET);
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
				System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
						+ "============================================================");
				System.out.println("||                                                        ||");
				System.out.println("||         A Recicle já agradece a sua doação!            ||");
				System.out.println("            O valor doado foi de: " + cliente.getSaldo() + "                     ");
				System.out.println("||                                                        ||");
				System.out.println("============================================================" + Cores.TEXT_RESET);
				cliente.setSaldo(0);
				keyPress();
				cadastrarCliente();
			} else if (validacao == 2) {
				menuPrincipal(cliente);
			}
		}
	}

	public static void visualizarContas(Cliente cliente) {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "Digite o seu CPF: "+Cores.TEXT_RESET);
		input.nextLine();
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND);
		String cpf = input.nextLine();
		System.out.println(Cores.TEXT_RESET);
		if (Objects.isNull(pessoas.buscarNaCollection(cpf))) {
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED + "Esse CPF não está cadastrado!\n"+ Cores.TEXT_RESET);
			menuPrincipal(cliente);
		} else {
			cliente.visualizar();
			menuPrincipal(cliente);
		}
	}

	public static void digiteNumeros() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED + "\nPor favor, digite números inteiros! \n"
				+ Cores.TEXT_RESET);
	}

	public static void naoValido() {
		System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED
				+ "Opção inválida, por favor, digite novamente \n" + Cores.TEXT_RESET);
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_WHITE + "\nPressione Enter para continuar... "
					+ Cores.TEXT_RESET);
			System.in.read();
		} catch (IOException e) {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_RED
					+ "Você pressionou uma tecla diferente de Enter!" + Cores.TEXT_RESET);
		}
	}

}
