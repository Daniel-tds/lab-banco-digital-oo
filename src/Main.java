import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        MenuBanco service = new MenuBanco(banco, scanner);

        while (true) {
            System.out.println("\n=== Banco Digital ===");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Listar Contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Imprimir Extrato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> service.criarConta();
                case 2 -> service.listarContas();
                case 3 -> service.depositar();
                case 4 -> service.sacar();
                case 5 -> service.transferir();
                case 6 -> service.imprimirExtrato();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
