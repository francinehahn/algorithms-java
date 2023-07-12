package numberOfBankNotes;

import java.util.Scanner;

public class NumberOfBankNotes {
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
        NumberOfBankNotes object = new NumberOfBankNotes();
        object.numberOfBankNotes();
    }
}
