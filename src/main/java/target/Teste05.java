package target;

import java.util.Scanner;

public class Teste05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite uma string: ");
        String str = scan.nextLine();

        if (!str.isEmpty()) {
            String[] letras = str.split("");

            System.out.println("String invertida: ");
            for (int i = letras.length - 1; i >= 0; i--) {
                System.out.print(letras[i]);
            }
        } else {
            System.out.println("String inválida. Por favor, insira uma string não vazia.");
        }

        scan.close();
    }
}
