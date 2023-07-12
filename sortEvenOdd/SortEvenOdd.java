package sortEvenOdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortEvenOdd {
    public static void sortNumbers() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a quantidade de números que você deseja incluir: ");
            int quantity = scanner.nextInt();

            if (quantity < 2 || quantity > 100000) {
                throw new RuntimeException("A quantidade de números deve ser maior do que 1 e menor do que 100000.");
            }

            List<Integer> even = new ArrayList<>();
            List<Integer> odd = new ArrayList<>();

            for (int i = 0; i < quantity; i++) {
                System.out.print("Digite o número desejado: ");
                int n = scanner.nextInt();

                if (n < 1) {
                    throw new RuntimeException("O valor do número digitado deve ser maior ou igual a 1.");
                }

                if (n % 2 == 0) {
                    even.add(n);
                } else {
                    odd.add(n);
                }
            }

            Collections.sort(even);
            Collections.sort(odd, Collections.reverseOrder());

            System.out.println("Resposta:");
            for (int valor : even) {
                System.out.println(valor);
            }

            for (int valor : odd) {
                System.out.println(valor);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SortEvenOdd object = new SortEvenOdd();
        object.sortNumbers();
    }
};