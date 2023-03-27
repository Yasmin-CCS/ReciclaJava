package reciclarJa;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import reciclarJa.model.Material;
import reciclarJa.controller.ReciclarJaController;
import reciclarJa.model.Compra;
import reciclarJa.model.Pessoa;


public class Menu {
	static ArrayList<Material> materiais = new ArrayList();
	static Scanner input = new Scanner(System.in);
	static ArrayList<Compra> compras = new ArrayList();

	public static void main(String[] args) {
		
		ReciclarJaController contas = new ReciclarJaController();
		
		Material papel = new Material("Papel", (float) 0.05);
		Material plastico = new Material("Plástico", (float) 0.10);
		Material vidro = new Material("Vidro", (float) 0.15);
		Material metal = new Material("Metal", (float) 0.20);
		Material organico = new Material("Orgânico", (float) 0.25);
		Material naoReciclavel = new Material("Não reciclável", (float) 0.30);
		materiais.add(papel);
		materiais.add(plastico);
		materiais.add(vidro);
		materiais.add(metal);
		materiais.add(organico);
		materiais.add(naoReciclavel);
		String nomeCliente = menuPrimario(input);
		int escolher = menuSecundário(input, nomeCliente);
		menuMaterias(escolher);
		menuCredito(escolher);

	}

	public static String menuPrimario(Scanner input) {
		String nome = "";
		while (nome.isEmpty()) {
			System.out.println(" ================================================================================");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                      Bem vinde ao ReciclarJá                               ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||                    Por favor,qual o seu nome?                              ||");
			System.out.println(" ||                                                                            ||");
			System.out.println(" ||============================================================================||");
			System.out.println(" ||            Para o nome, por favor, utilizar apenas letras(A-Z)             ||");
			System.out.println(" ================================================================================");
			nome = input.nextLine();
		}
		return nome;
	}

	public static int menuSecundário(Scanner input, String nome) {
		int opcao = 0;
		while (opcao != 1 && opcao != 2) {
			System.out.println(" ================================================================================");
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
				opcao = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite números inteiros! ");
				input.nextLine();
				opcao = 0;
			}
			if (opcao == 1 || opcao == 2) {
				System.out.println("Redirecionando...");
			} else {
				System.out.println("A opção não existe, por favor, selecione uma opção válida!");
			}

		}
		return opcao;
	}

	public static void menuCredito(int opcao) {

		if (opcao == 1) {
			System.out.println("Olá");

		}
		keyPress();
	}

	public static void menuMaterias(int opcao) {
		int escolha = 0;

		if (opcao == 2) {
			while (escolha < 1 || escolha > 6) {
				System.out.println(" ================================================================================");
				System.out.println(" ||============================================================================||");
				System.out.println(" ||                                                                            ||");
				System.out.println(" ||                          Bem vinde ao ReciclarJá                           ||");
				System.out.println(" ||                             Menu de Materiais                              ||");
				System.out.println(" ||                                                                            ||");
				System.out.println(" ||============================================================================||");
				System.out.println(" ||       (1) Papel   ||          (2) Plástico          || (3) Vidro           ||");
				System.out.println(" ||============================================================================||");
				System.out.println(" ||       (4) Metal   ||          (5) Orgânico          || (6) Não Reciclável  ||");
				System.out.println(" ||============================================================================||");
				System.out.println(" ||                          Digite a opção desejada :                         ||");
				System.out.println(" ================================================================================");
				escolha = input.nextInt();
				if (escolha < 1 || escolha > 6) {
					System.out.println("Opção inválida, por favor,digite novamente");
				} else {
					materiais.get(escolha - 1).visualizar();
					System.out.println("Qual o peso que deseja reciclar? ");
					float peso = input.nextFloat();
					Compra um = new Compra(materiais.get(escolha - 1), peso);
					compras.add(um);
					um.valorCompra();
					um.ver();
				}

			}
		}
		keyPress();
	}

	public static void keyPress() {

		try {

			System.out.println("\nPressione Enter para continuar... ");
			System.in.read();
		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}

}
