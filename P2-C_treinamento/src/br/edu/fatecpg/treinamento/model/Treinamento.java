package br.edu.fatecpg.treinamento.model;

import java.util.ArrayList;

public class Treinamento {
    public static final int LIMITE_HORAS_A_CADA_2_MESES = 80;

    protected int id;
    protected String nomeInstrutor;
    protected String linguagemEnsinada;
    protected ArrayList<Aluno> alunos;
    protected int cargaHoraria;
    protected boolean instrutorDisponivel;

    public Treinamento(int id, String nomeInstrutor, String linguagemEnsinada, boolean instrutorDisponivel) {
        this.id = id;
        this.nomeInstrutor = nomeInstrutor;
        this.linguagemEnsinada = linguagemEnsinada;
        this.instrutorDisponivel = instrutorDisponivel;
        this.alunos = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNomeInstrutor() { return nomeInstrutor; }
    public String getLinguagemEnsinada() { return linguagemEnsinada; }
    public ArrayList<Aluno> getAlunos() { return alunos; }
    public int getCargaHoraria() { return cargaHoraria; }

    public void inscreverAluno(Aluno aluno) {
        if (verificarUltimoTreinamento(aluno)) {
            alunos.add(aluno);
            aluno.setHorasUltimosDoisMeses(aluno.getHorasUltimosDoisMeses() + cargaHoraria);
            System.out.println(aluno.getNome() + " inscrito(a) no treinamento " + id);
        } else {
            System.out.println(aluno.getNome() + " NÃO pode se inscrever: limite de "
                    + LIMITE_HORAS_A_CADA_2_MESES + "h a cada 2 meses excedido.");
        }
    }

    public boolean verificarDisponibilidade() {
        return instrutorDisponivel;
    }

    public void definirCargaHoraria(int horas) {
        if (horas <= 0) {
            System.out.println("Carga horária inválida.");
            return;
        }
        this.cargaHoraria = horas;
    }

    public boolean verificarUltimoTreinamento(Aluno aluno) {
        return aluno.getHorasUltimosDoisMeses() + cargaHoraria <= LIMITE_HORAS_A_CADA_2_MESES;
    }

    public double calcularMediaAlunos() {
        if (alunos.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Aluno a : alunos) {
            soma += a.getNotaFinal();
        }
        return soma / alunos.size();
    }

    public void exibirDetalhes() {
        System.out.println("Treinamento #" + id);
        System.out.println("Instrutor: " + nomeInstrutor + (instrutorDisponivel ? " (disponível)" : " (indisponível)"));
        System.out.println("Linguagem: " + linguagemEnsinada);
        System.out.println("Carga horária: " + cargaHoraria + "h");
        System.out.println("Alunos: " + alunos);
        System.out.printf("Média das notas: %.2f%n", calcularMediaAlunos());
    }

    public void iniciarTreinamento() {
        if (!verificarDisponibilidade()) {
            System.out.println("Instrutor indisponível. Treinamento não iniciado.");
            return;
        }
        System.out.println("Treinamento " + id + " iniciado.");
    }
}
