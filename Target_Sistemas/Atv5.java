import java.util.Scanner;

public class Atv5 {
    public static void main(String[] args) {
        // Entrada de dados pelo usuário
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String input = scanner.nextLine();

        // Variável para armazenar a string invertida
        String invertida = "";

        // Inverter a string manualmente, percorrendo do último caractere ao primeiro
        for (int i = input.length() - 1; i >= 0; i--) {
            invertida += input.charAt(i);
        }

        // Exibir a string invertida
        System.out.println("String invertida: " + invertida);
        
        scanner.close();
    }
}

