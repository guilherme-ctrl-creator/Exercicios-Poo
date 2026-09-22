import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    String nome;
    int idade;
    double nota1;
    double nota2;

    Aluno(String nome, int idade, double nota1, double nota2) {
        this.nome = nome;
        this.idade = idade;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    boolean estaAprovado() {
        return calcularMedia() >= 7;
    }

    String situacao() {

        if (calcularMedia() >= 7) {
            return "Aprovado";
        } else if (calcularMedia() >= 5) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    void exibirSituacao() {
        System.out.println(
            nome + " - Média: " + calcularMedia() +
            " - " + situacao()
        );
    }
}

public class CadastroAlunos {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("Aluno " + (i + 1));

            System.out.print("Nome: ");
            String nome = teclado.nextLine();

            System.out.print("Idade: ");
            int idade = teclado.nextInt();

            System.out.print("Nota 1: ");
            double nota1 = teclado.nextDouble();

            System.out.print("Nota 2: ");
            double nota2 = teclado.nextDouble();

            teclado.nextLine();

            alunos.add(new Aluno(nome, idade, nota1, nota2));

            System.out.println();
        }

        int aprovados = 0;
        double maiorMedia = 0;

        System.out.println("\nALUNOS:");

        for (Aluno a : alunos) {

            a.exibirSituacao();

            if (a.estaAprovado()) {
                aprovados++;
            }

            if (a.calcularMedia() > maiorMedia) {
                maiorMedia = a.calcularMedia();
            }
        }

        System.out.println("\nQuantidade de aprovados: " + aprovados);
        System.out.println("Maior média: " + maiorMedia);

        teclado.close();
    }
}