import java.util.ArrayList;
import java.util.Scanner;

class Conta {
    int numero;
    String titular;
    double saldo;

    Conta(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor inválido.");
        }
    }

    void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saque inválido.");
        }
    }

    double consultarSaldo() {
        return saldo;
    }

    void exibirDados() {
        System.out.println(
            "Conta: " + numero +
            " - Titular: " + titular +
            " - Saldo: R$ " + saldo
        );
    }
}

public class ControleContas {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("Conta " + (i + 1));

            System.out.print("Número da conta: ");
            int numero = teclado.nextInt();

            teclado.nextLine();

            System.out.print("Titular: ");
            String titular = teclado.nextLine();

            System.out.print("Saldo inicial: ");
            double saldo = teclado.nextDouble();

            teclado.nextLine();

            contas.add(new Conta(numero, titular, saldo));

            System.out.println();
        }

        System.out.print("Digite o número da conta: ");
        int numeroBusca = teclado.nextInt();

        for (Conta c : contas) {

            if (c.numero == numeroBusca) {

                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");

                System.out.print("Escolha: ");
                int opcao = teclado.nextInt();

                System.out.print("Valor: ");
                double valor = teclado.nextDouble();

                if (opcao == 1) {
                    c.depositar(valor);
                } else if (opcao == 2) {
                    c.sacar(valor);
                }
            }
        }

        Conta maior = contas.get(0);

        System.out.println("\nCONTAS:");

        for (Conta c : contas) {

            c.exibirDados();

            if (c.saldo > maior.saldo) {
                maior = c;
            }
        }

        System.out.println(
            "\nConta com maior saldo: " +
            maior.numero + " - " + maior.titular
        );

        teclado.close();
    }
}