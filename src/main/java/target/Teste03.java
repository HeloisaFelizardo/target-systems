package target;

public class Teste03 {
    public static void main(String[] args) {
        int INDICE = 12;
        int SOMA = 0;
        int K = 1;

        while (K < INDICE) {
            K = K + 1;
            SOMA = SOMA + K;
        }

        System.out.println(SOMA);
        //77
    }
}
