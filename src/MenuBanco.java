import java.util.Scanner;

public class MenuBanco {

    private Banco banco;
    private Scanner scanner;

    public MenuBanco(Banco banco, Scanner scanner) {
        this.banco = banco;
        this.scanner = scanner;
    }

    public void criarConta() {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        System.out.print("Tipo de Conta (1 - Corrente, 2 - Poupança): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Conta conta = (tipo == 1) ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);
        banco.adicionarConta(conta);

        System.out.println("Conta criada com sucesso! Número da conta: " + conta.getNumero());
    }

    public void listarContas() {
        if (banco.getContas().isEmpty()) {
            System.out.println("Nenhuma conta cadastrada!");
            return;
        }
        System.out.println("=== Lista de Contas ===");
        for (Conta c : banco.getContas()) {
            System.out.println("Conta #" + c.getNumero() + " - Titular: " + c.getCliente().getNome());
        }
    }

    public void depositar() {
        Conta conta = encontrarConta();
        if (conta == null) return;

        System.out.print("Valor do Depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar() {
        Conta conta = encontrarConta();
        if (conta == null) return;

        System.out.print("Valor do Saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        conta.sacar(valor);
        System.out.println("Saque realizado com sucesso!");
    }

    public void transferir() {
        System.out.println("Conta de Origem:");
        Conta origem = encontrarConta();
        if (origem == null) return;

        System.out.println("Conta de Destino:");
        Conta destino = encontrarConta();
        if (destino == null) return;

        System.out.print("Valor da Transferência: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        origem.transferir(valor, destino);
        System.out.println("Transferência realizada com sucesso!");
    }

    public void imprimirExtrato() {
        Conta conta = encontrarConta();
        if (conta != null) conta.imprimirExtrato();
    }

    private Conta encontrarConta() {
        System.out.print("Número da Conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if (conta == null) System.out.println("Conta não encontrada!");
        return conta;
    }
}
