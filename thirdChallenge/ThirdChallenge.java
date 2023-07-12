/* Dado um array de inteiros e um valor alvo, determine o número de pares entre os elementos
do array em que a sua diferença seja igual ao valor alvo.

Exemplo
K = 1
arr = [1,2,3,4]
Existem 3 valores cuja diferença é igual ao valor alvo K: 2-1 = 1, 3-2 = 1, 4-3 = 1.
*/

package thirdChallenge;

public class ThirdChallenge {
    private int[] array;
    private int targetNumber;

    public ThirdChallenge(int[] array, int targetNumber) {
        this.array = array;
        this.targetNumber = targetNumber;
    }

    public int numberOfEvenNumbers() {
        int sum = 0;
        
        try {
            for (int i = 0; i < this.array.length; i++) {
                if (array[i] % 2 == 0) {
                    for (int j = 0; j < this.array.length; j++) {
                        if (j != i && Math.abs(array[i] - array[j]) == this.targetNumber) {
                            sum += 1;
                        }
                    }
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int targetNumber = 1;

        ThirdChallenge object = new ThirdChallenge(array, targetNumber);
        int n = object.numberOfEvenNumbers();
        System.out.println("Existem " + n + " valores onde a diferença para os outros elementos da lista são igual ao valor alvo.");
    }
}
