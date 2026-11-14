package br.edu.fatecpg.treinamento.model;

public class TreinamentoOnline extends Treinamento {
    private String linkAcesso;

    public TreinamentoOnline(int id, String nomeInstrutor, String linguagemEnsinada,
                             boolean instrutorDisponivel, String linkAcesso) {
        super(id, nomeInstrutor, linguagemEnsinada, instrutorDisponivel);
        this.linkAcesso = linkAcesso;
    }

    public String getLinkAcesso() { return linkAcesso; }
    public void setLinkAcesso(String linkAcesso) { this.linkAcesso = linkAcesso; }

    public void enviarLinkAosAlunos() {
        for (Aluno a : alunos) {
            System.out.println("Link enviado para " + a.getNome() + ": " + linkAcesso);
        }
    }

    @Override
    public void iniciarTreinamento() {
        if (!verificarDisponibilidade()) {
            System.out.println("Instrutor indisponível. Treinamento online não iniciado.");
            return;
        }
        System.out.println("Treinamento online " + id + " iniciado. Acesso: " + linkAcesso);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("--- Treinamento ONLINE ---");
        super.exibirDetalhes();
        System.out.println("Link de acesso: " + linkAcesso);
    }
}
