package view;

import java.util.Scanner;
import controller.KillController;

public class Main {

    public static void main(String[] args) {
        KillController kc = new KillController();
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Listar processos");
            System.out.println("2 - Matar por PID");
            System.out.println("3 - Matar por Nome");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    kc.listaProcessos();
                    break;

                case 2:
                    System.out.print("Digite o PID: ");
                    String pid = sc.nextLine();
                    kc.mataPid(pid);
                    break;

                case 3:
                    System.out.print("Digite o nome do processo: ");
                    String nome = sc.nextLine();
                    kc.mataNome(nome);
                    break;

                case 4:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}
