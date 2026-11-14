package br.edu.fatecpg.treinamento.model;

public class TreinamentoPresencial extends Treinamento {
    private String local;

    public TreinamentoPresencial(int id, String nomeInstrutor, String linguagemEnsinada,
                                 boolean instrutorDisponivel, String local) {
        super(id, nomeInstrutor, linguagemEnsinada, instrutorDisponivel);
        this.local = local;
    }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public void reservarSala() {
        System.out.println("Sala reservada em: " + local);
    }

    @Override
    public void iniciarTreinamento() {
        if (!verificarDisponibilidade()) {
            System.out.println("Instrutor indisponível. Treinamento presencial não iniciado.");
            return;
        }
        System.out.println("Treinamento presencial " + id + " iniciado em: " + local);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Treinamento PRESENCIAL ---");
        super.exibirDetalhes();
        System.out.println("Local: " + local);
    }
}
