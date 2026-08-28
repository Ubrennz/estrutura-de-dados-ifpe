package v2026_08_27;

import java.util.Scanner;

public class ListaEncadeadaTarefas {
    static class Tarefa {
        String descricao;
        boolean concluida;

        Tarefa(String descricao) {
            this.descricao = descricao;
            this.concluida = false;
        }

        @Override
        public String toString() {
            String status = concluida ? "[X]" : "[ ]";
            return status + " " + descricao;
        }
    }

    static class No {
        Tarefa tarefa;
        No proximo;

        No(Tarefa tarefa) {
            this.tarefa = tarefa;
            this.proximo = null;
        }
    }

    static class ListaTarefas {
        No inicio;

        void adicionar(String descricao) {
            No novoNo = new No(new Tarefa(descricao));

            if (inicio == null) {
                inicio = novoNo;
                return;
            }

            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }

        boolean remover(int indice) {
            if (inicio == null || indice < 0) {
                return false;
            }

            if (indice == 0) {
                inicio = inicio.proximo;
                return true;
            }

            No atual = inicio;
            int posicaoAtual = 0;

            while (atual.proximo != null && posicaoAtual < indice - 1) {
                atual = atual.proximo;
                posicaoAtual++;
            }

            if (atual.proximo == null) {
                return false; // índice fora do intervalo
            }

            atual.proximo = atual.proximo.proximo;
            return true;
        }

        boolean concluir(int indice) {
            No atual = inicio;
            int posicaoAtual = 0;

            while (atual != null) {
                if (posicaoAtual == indice) {
                    atual.tarefa.concluida = true;
                    return true;
                }
                atual = atual.proximo;
                posicaoAtual++;
            }

            return false;
        }

        void imprimir() {
            if (inicio == null) {
                System.out.println("Nenhuma tarefa cadastrada.");
                return;
            }

            No atual = inicio;
            int indice = 0;
            System.out.println("----- Lista de Tarefas -----");
            while (atual != null) {
                System.out.println(indice + " - " + atual.tarefa);
                atual = atual.proximo;
                indice++;
            }
        }

        int tamanho() {
            int contador = 0;
            No atual = inicio;
            while (atual != null) {
                contador++;
                atual = atual.proximo;
            }
            return contador;
        }
    }

    public static void main(String[] args) {
        ListaTarefas lista = new ListaTarefas();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine().trim();
                    if (descricao.isEmpty()) {
                        System.out.println("A tarefa não pode estar vazia.");
                    } else {
                        lista.adicionar(descricao);
                        System.out.println("Tarefa adicionada.");
                    }
                    break;
                case 2:
                    lista.imprimir();
                    break;
                case 3:
                    lista.imprimir();
                    System.out.print("Digite o índice da tarefa a remover: ");
                    int indiceRemover = lerInteiro(scanner);
                    boolean removida = lista.remover(indiceRemover);
                    System.out.println(removida ? "Tarefa removida." : "Índice inválido.");
                    break;
                case 4:
                    lista.imprimir();
                    System.out.print("Digite o índice da tarefa a concluir: ");
                    int indiceConcluir = lerInteiro(scanner);
                    boolean concluida = lista.concluir(indiceConcluir);
                    System.out.println(concluida ? "Tarefa marcada como concluída." : "Índice inválido.");
                    break;
                case 5:
                    System.out.println("Total de tarefas: " + lista.tamanho());
                    break;
                case 6:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            System.out.println();

        } while (opcao != 6);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== Lista Encadeada de Tarefas =====");
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Remover tarefa");
        System.out.println("4 - Concluir tarefa");
        System.out.println("5 - Total de tarefas");
        System.out.println("6 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerInteiro(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
