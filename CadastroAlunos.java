import java.util.ArrayList;

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
        double media = calcularMedia();

        if (media >= 7) {
            return "Aprovado";
        } else if (media >= 5) {
            return "Recuperação";
        } else {
            return "Reprovado";
        }
    }

    void exibirSituacao() {
        System.out.println(nome + " - Média: " + calcularMedia()
                + " - " + situacao());
    }
}

public class CadastroAlunos {
    public static void main(String[] args) {

        ArrayList<Aluno> alunos = new ArrayList<>();

        alunos.add(new Aluno("Lucas", 18, 8, 7));
        alunos.add(new Aluno("Maria", 19, 9, 8));
        alunos.add(new Aluno("João", 20, 6, 5));
        alunos.add(new Aluno("Ana", 18, 4, 3));
        alunos.add(new Aluno("Pedro", 21, 7, 9));

        int aprovados = 0;
        double maiorMedia = 0;

        for (Aluno a : alunos) {
            a.exibirSituacao();

            if (a.estaAprovado()) {
                aprovados++;
            }

            if (a.calcularMedia() > maiorMedia) {
                maiorMedia = a.calcularMedia();
            }
        }

        System.out.println("Aprovados: " + aprovados);
        System.out.println("Maior média: " + maiorMedia);
    }
}