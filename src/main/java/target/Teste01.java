package target;

import java.util.Scanner;

public class Teste01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();
        scanner.close();

        if (pertenceFibonacci(numero)) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }

    public static boolean pertenceFibonacci(int numero) {
        if (numero < 0) {
            return false;
        }
        int a = 0;
        int b = 1;
        while (a < numero) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a == numero;
    }
}
