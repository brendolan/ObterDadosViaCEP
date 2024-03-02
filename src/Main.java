import br.com.brendolan.classes.Endereco;
import br.com.brendolan.classes.ObterDados;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o CEP: ");
            String cep = scanner.nextLine();

            ObterDados obterdados = new ObterDados();
            Endereco meuEndereco = obterdados.buscar(cep);

            System.out.println(meuEndereco);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}