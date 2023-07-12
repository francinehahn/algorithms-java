/* Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor
monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor
pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas
possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas
necessárias.

Entrada
O arquivo de entrada contém um valor de ponto flutuante N (0 ≤ N ≤ 1000000.00).

Saída
Imprima a quantidade mínima de notas e moedas necessárias para trocar o valor inicial,
conforme exemplo fornecido.
*/

package secondChallenge;

import java.util.Scanner;

public class SecondChallenge {
    public static void numberOfBankNotes() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite o valor em reais: ");
            String input = scanner.next();
            Double value = new Double(input);

            if (value < 0 || value > 1000000.00) {
                throw new RuntimeException("O valor em reais deve ser maior ou igual a 0 e menor ou igual a 1000000.00");
            }

            int[] notes = {100, 50, 20, 10, 5, 2};
            double[] coins = {1.0, 0.5, 0.25, 0.1, 0.05, 0.01};

            System.out.println("NOTAS:");
            for (int i = 0; i < notes.length; i++) {
                int numberOfNotes = (int) (value / notes[i]);
                System.out.println(numberOfNotes + " nota(s) de R$ " + notes[i] + ".00");
                value %= notes[i];
            }

            System.out.println("MOEDAS:");
            for (int i = 0; i < coins.length; i++) {
                int quantidadeMoedas = (int) (value / coins[i]);
                System.out.println(quantidadeMoedas + " moeda(s) de R$ " + String.format("%.2f", coins[i]));
                value %= coins[i];
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
     
    public static void main(String[] args) {
        SecondChallenge object = new SecondChallenge();
        object.numberOfBankNotes();
    }
}
