package target.teste03;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class CalculadoraFaturamento {
    public static void main(String[] args) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                Faturamento[] faturamentos = mapper.readValue(new File("dados.json"), Faturamento[].class);
                calcularFaturamento(faturamentos);
            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo de faturamento: " + e.getMessage());
            }
        }

        public static void calcularFaturamento(Faturamento[] faturamentos) {
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double totalFaturamento = 0;
            int diasComFaturamento = 0;

            for (Faturamento faturamento : faturamentos) {
                if (faturamento.getValor() > 0) {
                    if (faturamento.getValor() < menorValor) {
                        menorValor = faturamento.getValor();
                    }
                    if (faturamento.getValor() > maiorValor) {
                        maiorValor = faturamento.getValor();
                    }
                    totalFaturamento += faturamento.getValor();
                    diasComFaturamento++;
                }
            }

            // Calcula a média mensal de dias com faturamento
            double mediaMensal = totalFaturamento / diasComFaturamento;

            // Conta quantos dias tiveram faturamento acima da média
            long diasAcimaDaMedia = Arrays.stream(faturamentos)
                    .filter(f -> f.getValor() > mediaMensal && f.getValor() > 0)  // Ignora dias sem faturamento
                    .count();

            // Exibe os resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
