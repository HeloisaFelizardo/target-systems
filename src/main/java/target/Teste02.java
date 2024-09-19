package target;

import java.util.Scanner;

public class Teste02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int number = scanner.nextInt();
        scanner.close();

        if (isFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " não pertence à sequência de Fibonacci.");
        }
    }

    public static boolean isFibonacci(int number) {
        if (number < 0) {
            return false;
        }
        int a = 0;
        int b = 1;
        while (a < number) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a == number;
    }
}

