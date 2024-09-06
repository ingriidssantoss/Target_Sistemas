import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Atv3 {

    public static class FaturamentoDia {
        public int dia;
        public double valor;
    }

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Ler o arquivo JSON contendo o faturamento
            List<FaturamentoDia> faturamentoMensal = objectMapper.readValue(
                new File("faturamento.json"), 
                new TypeReference<List<FaturamentoDia>>() {}
            );

            double menorFaturamento = Double.MAX_VALUE;
            double maiorFaturamento = Double.MIN_VALUE;
            double somaFaturamento = 0;
            int diasComFaturamento = 0;

            // Encontrar o menor, maior faturamento e calcular a soma para a média
            for (FaturamentoDia dia : faturamentoMensal) {
                if (dia.valor > 0) {
                    if (dia.valor < menorFaturamento) {
                        menorFaturamento = dia.valor;
                    }
                    if (dia.valor > maiorFaturamento) {
                        maiorFaturamento = dia.valor;
                    }
                    somaFaturamento += dia.valor;
                    diasComFaturamento++;
                }
            }

            // Calcular a média de faturamento dos dias com faturamento positivo
            double mediaMensal = somaFaturamento / diasComFaturamento;

            // Contar os dias com faturamento acima da média
            int diasAcimaDaMedia = 0;
            for (FaturamentoDia dia : faturamentoMensal) {
                if (dia.valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibir os resultados
            System.out.println("Menor faturamento diário: " + menorFaturamento);
            System.out.println("Maior faturamento diário: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média mensal: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

