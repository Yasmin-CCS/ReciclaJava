package reciclarJa.doacao;

import java.util.Scanner;
import reciclarJa.controller.ReciclarJaController;
import reciclarJa.util.Cores;

public class campodoacao extends ReciclarJaController {
	
	Scanner leia = new Scanner (System.in);
	int opcao;
	
	//mansagem que vai aparecer quando a pessoa selecionar que quer doar OU se selecionar que não quer cadastrar CPF
	public void msgdoacao () {
		System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "===============================================================================================================================");
		System.out.println("||                                                                                                                           ||");
		System.out.println("||     Os créditos serão doados para projetos que incentivam o plantio de árvores na Amazonia, deseja continuar?             ||");
		System.out.println("||                                      (1) - Sim |  (2) - Não                                                               ||"); 
		System.out.println("||                                                                                                                           ||");
		System.out.println("===============================================================================================================================" + Cores.TEXT_RESET);
		
	}
	
	//lendo a opção selecionada
	public void doar (int opcao) {
		opcao = leia.nextInt ();
		//selecionou que quer doar
		if (opcao == 1) {
			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND + "============================================================");
			System.out.println("||                                                        ||");                                                                                    
			System.out.println("||         A Recicle já agradece a sua doação!            ||");
			System.out.println("||                                                        ||");
			System.out.println("============================================================" + Cores.TEXT_RESET);
			
			
		//caso selecione não - voltar para a parte " quer continuar acrescentando / doar / salvar crédito"
		}else if (opcao == 2) {
		
		//caso selecione uma mensagem de erro;
		}else {
			System.out.println(Cores.TEXT_RED + Cores.ANSI_BLACK_BACKGROUND + "=======================================================");
			System.out.println("\n||                                                 ||\n");                                                                                    
			System.out.println("\n||           Digite uma opçao válida               ||\n");
			System.out.println("\n||                                                 ||\n");
			System.out.println("=======================================================" + Cores.TEXT_RESET);
		}
	}
}
		
