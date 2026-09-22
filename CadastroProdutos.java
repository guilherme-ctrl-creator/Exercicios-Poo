import java.util.ArrayList;
import java.util.Scanner;

class Produto {
    String nome;
    double preco;
    int quantidade;

    Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    void adicionarEstoque(int qtd) {
        quantidade += qtd;
    }

    void removerEstoque(int qtd) {
        if (qtd <= quantidade) {
            quantidade -= qtd;
        }
    }

    double calcularValorEstoque() {
        return preco * quantidade;
    }

    void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor em estoque: R$ " + calcularValorEstoque());
        System.out.println();
    }
}

public class CadastroProdutos {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("Produto " + (i + 1));

            System.out.print("Nome: ");
            String nome = teclado.nextLine();

            System.out.print("Preço: ");
            double preco = teclado.nextDouble();

            System.out.print("Quantidade: ");
            int quantidade = teclado.nextInt();

            teclado.nextLine();

            produtos.add(new Produto(nome, preco, quantidade));

            System.out.println();
        }

        System.out.print("Quantidade para adicionar no primeiro produto: ");
        int adicionar = teclado.nextInt();

        produtos.get(0).adicionarEstoque(adicionar);

        System.out.print("Quantidade para remover do segundo produto: ");
        int remover = teclado.nextInt();

        produtos.get(1).removerEstoque(remover);

        double total = 0;
        Produto maior = produtos.get(0);

        System.out.println("\nPRODUTOS:");

        for (Produto p : produtos) {

            p.exibirDados();

            total += p.calcularValorEstoque();

            if (p.calcularValorEstoque() > maior.calcularValorEstoque()) {
                maior = p;
            }
        }

        System.out.println("Valor total do estoque: R$ " + total);
        System.out.println("Produto com maior valor em estoque: " + maior.nome);

        teclado.close();
    }
}