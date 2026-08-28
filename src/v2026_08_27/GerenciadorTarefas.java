package v2026_08_27;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefas {

    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    adicionarTarefa(scanner, tarefas);
                    break;
                case 2:
                    listarTarefas(tarefas);
                    break;
                case 3:
                    removerTarefa(scanner, tarefas);
                    break;
                case 4:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();

        } while (opcao != 4);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== Gerenciador de Tarefas =====");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Remover tarefa");
        System.out.println("4 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        int opcao;
        try {
            opcao = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            opcao = -1;
        }
        return opcao;
    }

    private static void adicionarTarefa(Scanner scanner, ArrayList<String> tarefas) {
        System.out.print("Digite a descrição da nova tarefa: ");
        String descricao = scanner.nextLine().trim();

        if (descricao.isEmpty()) {
            System.out.println("A tarefa não pode estar vazia.");
            return;
        }

        tarefas.add(descricao);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private static void listarTarefas(ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        System.out.println("----- Lista de Tarefas -----");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println(i + " - " + tarefas.get(i));
        }
    }

    private static void removerTarefa(Scanner scanner, ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para remover.");
            return;
        }

        listarTarefas(tarefas);
        System.out.print("Digite o índice da tarefa a remover: ");

        try {
            int indice = Integer.parseInt(scanner.nextLine().trim());

            if (indice < 0 || indice >= tarefas.size()) {
                System.out.println("Índice inválido.");
                return;
            }

            String removida = tarefas.remove(indice);
            System.out.println("Tarefa removida: " + removida);

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
        }
    }
}