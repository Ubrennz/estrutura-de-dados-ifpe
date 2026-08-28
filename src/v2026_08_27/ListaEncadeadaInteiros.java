package v2026_08_27;

import java.util.Scanner;

public class ListaEncadeadaInteiros {
    static class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    static class Lista {
        No inicio;

        void adicionar(int valor) {
            No novoNo = new No(valor);

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

        boolean remover(int valor) {
            if (inicio == null) {
                return false;
            }

            if (inicio.valor == valor) {
                inicio = inicio.proximo;
                return true;
            }

            No atual = inicio;
            while (atual.proximo != null) {
                if (atual.proximo.valor == valor) {
                    atual.proximo = atual.proximo.proximo;
                    return true;
                }
                atual = atual.proximo;
            }

            return false;
        }

        boolean contem(int valor) {
            No atual = inicio;
            while (atual != null) {
                if (atual.valor == valor) {
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        void imprimir() {
            if (inicio == null) {
                System.out.println("Lista vazia.");
                return;
            }

            No atual = inicio;
            System.out.print("Lista: ");
            while (atual != null) {
                System.out.print(atual.valor);
                if (atual.proximo != null) {
                    System.out.print(" -> ");
                }
                atual = atual.proximo;
            }
            System.out.println();
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
        Lista lista = new Lista();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número inteiro a adicionar: ");
                    int valorAdicionar = lerInteiro(scanner);
                    lista.adicionar(valorAdicionar);
                    System.out.println("Valor adicionado.");
                    break;
                case 2:
                    lista.imprimir();
                    break;
                case 3:
                    System.out.print("Digite o número inteiro a remover: ");
                    int valorRemover = lerInteiro(scanner);
                    boolean removido = lista.remover(valorRemover);
                    System.out.println(removido ? "Valor removido." : "Valor não encontrado.");
                    break;
                case 4:
                    System.out.print("Digite o número inteiro a buscar: ");
                    int valorBuscar = lerInteiro(scanner);
                    System.out.println(lista.contem(valorBuscar) ? "Valor encontrado." : "Valor não encontrado.");
                    break;
                case 5:
                    System.out.println("Tamanho da lista: " + lista.tamanho());
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
        System.out.println("===== Lista Encadeada de Inteiros =====");
        System.out.println("1 - Adicionar valor");
        System.out.println("2 - Listar valores");
        System.out.println("3 - Remover valor");
        System.out.println("4 - Buscar valor");
        System.out.println("5 - Tamanho da lista");
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
