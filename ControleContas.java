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
        }
    }

    void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }

    double consultarSaldo() {
        return saldo;
    }

    void exibirDados() {
        System.out.println(numero + " - " + titular + " - R$ " + saldo);
    }
}

public class ControleContas {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        ArrayList<Conta> contas = new ArrayList<>();

        contas.add(new Conta(1, "Lucas", 1000));
        contas.add(new Conta(2, "Maria", 2000));
        contas.add(new Conta(3, "João", 500));
        contas.add(new Conta(4, "Ana", 3000));
        contas.add(new Conta(5, "Pedro", 1500));

        contas.get(0).depositar(500);
        contas.get(1).sacar(200);

        Conta maior = contas.get(0);

        for (Conta c : contas) {
            c.exibirDados();

            if (c.saldo > maior.saldo) {
                maior = c;
            }
        }

        System.out.println("Maior saldo: " + maior.titular);

        System.out.print("Digite o número da conta: ");
        int numero = teclado.nextInt();

        for (Conta c : contas) {

            if (c.numero == numero) {

                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");

                int opcao = teclado.nextInt();

                System.out.print("Valor: ");
                double valor = teclado.nextDouble();

                if (opcao == 1) {
                    c.depositar(valor);
                }

                if (opcao == 2) {
                    c.sacar(valor);
                }

                c.exibirDados();
            }
        }

        teclado.close();
    }
}