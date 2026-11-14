package br.edu.fatecpg.treinamento.model;

public class Aluno {
    private String nome;
    private double notaFinal;
    private int horasUltimosDoisMeses;

    public Aluno(String nome, double notaFinal, int horasUltimosDoisMeses) {
        this.nome = nome;
        this.notaFinal = notaFinal;
        this.horasUltimosDoisMeses = horasUltimosDoisMeses;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getNotaFinal() { return notaFinal; }
    public void setNotaFinal(double notaFinal) { this.notaFinal = notaFinal; }

    public int getHorasUltimosDoisMeses() { return horasUltimosDoisMeses; }
    public void setHorasUltimosDoisMeses(int horas) { this.horasUltimosDoisMeses = horas; }

    @Override
    public String toString() {
        return String.format("%s (nota final: %.1f)", nome, notaFinal);
    }
}
