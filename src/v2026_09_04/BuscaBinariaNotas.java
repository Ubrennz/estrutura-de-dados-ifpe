package v2026_09_04;

import java.util.Scanner;

public class BuscaBinariaNotas {

    public static void main(String[] args) {
        int[] notas = {75, 42, 90, 60, 35, 88, 50, 95, 70, 65};

        int n = notas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (notas[j] > notas[j + 1]) {
                    int temp = notas[j];
                    notas[j] = notas[j + 1];
                    notas[j + 1] = temp;
                }
            }
        }

        System.out.print("Notas ordenadas: ");
        for (int nota : notas) {
            System.out.print(nota + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a nota que deseja procurar: ");
        int alvo = sc.nextInt();

        int inicio = 0;
        int fim = notas.length - 1;
        int posicao = -1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (notas[meio] == alvo) {
                posicao = meio;
                break;
            } else if (notas[meio] < alvo) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (posicao != -1) {
            System.out.println("Nota encontrada na posição " + posicao);
        } else {
            System.out.println("Nota não encontrada");
        }

        sc.close();
    }
}
