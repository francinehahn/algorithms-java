/* A sua impressora foi infectada por um vírus e está imprimindo de forma incorreta. Depois
de olhar para várias páginas impressas por um tempo, você percebe que ele está
imprimindo cada linha de dentro para fora. Em outras palavras, a metade esquerda de cada
linha está sendo impressa a partir do meio da página até a margem esquerda. Do mesmo
modo, a metade direita de cada linha está sendo impressa à partir da margem direita e
prosseguindo em direção ao centro da página.

Por exemplo a linha:
THIS LINE IS GIBBERISH
está sendo impressa como:
I ENIL SIHTHSIREBBIG S

Da mesma forma, a linha " MANGOS " está sendo impressa incorretamente como
"NAM SOG". Sua tarefa é desembaralhar (decifrar) a string a partir da forma como ela foi
impressa para a sua forma original. Você pode assumir que cada linha conterá um número
par de caracteres.

Entrada
A entrada contém vários casos de teste. A primeira linha de entrada contém um
inteiro N que indica a quantidade de casos de teste. Seguem N linhas, cada uma com uma
frase com no mínimo 2 e no máximo 100 caracteres de letras maiúsculas e espaços que
deverá ser desembaralhada (decifrada) à partir da forma impressa para a sua forma
original, conforme especificação acima.

Saída
Para cada linha de entrada deverá ser impressa uma linha de saída com a frase decifrada,
conforme a especificação acima.
*/

package fourthChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FourthChallenge {
    public static void decipherWords() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a quantidade de testes que você deseja realizar: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            if (quantity < 2 || quantity > 100) {
                throw new RuntimeException("A quantidade de testes deve ser maior do que 1 e menor ou igual a 100.");
            }

            for (int i = 0; i < quantity; i++) {
                System.out.print("Digite a palavra que você deseja decifrar: ");
                String word = scanner.nextLine();

                int index = 0;
                if (word.length() % 2 == 0) {
                    index = word.length() / 2 - 1;
                } else {
                    index = (int) (word.length() / 2);
                }

                List<Character> listOfChars = new ArrayList<>();
                for (int j = index; j >= 0; j--) {
                    listOfChars.add(word.charAt(j));
                }
                for (int k = word.length() - 1; k > index; k--) {
                    listOfChars.add(word.charAt(k));
                }

                String result = String.join("", listOfChars.stream().map(Object::toString).collect(Collectors.toList()));
                System.out.println(result);
            }

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        FourthChallenge object = new FourthChallenge();
        object.decipherWords();
    }
}
