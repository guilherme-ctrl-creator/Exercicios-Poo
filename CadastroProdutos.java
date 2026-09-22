import java.util.ArrayList;

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
        System.out.println(nome + " - R$ " + preco + " - Qtd: " + quantidade);
    }
}

public class CadastroProdutos {
    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Mouse", 100, 10));
        produtos.add(new Produto("Teclado", 150, 5));
        produtos.add(new Produto("Monitor", 900, 3));
        produtos.add(new Produto("Fone", 200, 8));
        produtos.add(new Produto("Webcam", 250, 4));

        produtos.get(0).adicionarEstoque(5);
        produtos.get(1).removerEstoque(2);

        double total = 0;
        Produto maior = produtos.get(0);

        for (Produto p : produtos) {
            p.exibirDados();

            total += p.calcularValorEstoque();

            if (p.calcularValorEstoque() > maior.calcularValorEstoque()) {
                maior = p;
            }
        }

        System.out.println("Valor total: R$ " + total);
        System.out.println("Maior valor em estoque: " + maior.nome);
    }
}