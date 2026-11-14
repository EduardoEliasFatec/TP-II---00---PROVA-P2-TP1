package br.edu.fatecpg.passagens.model;

public class Voo {
    private static final double TAXA_PONTOS_TURISTICOS = 250.00;

    private String numeroVoo;
    private String origem;
    private String destino;
    private int assentosDisponiveis;
    private double precoPassagem;

    private int assentosReservados;
    private String tipoViagem;
    private boolean pontosTuristicos;
    private double valorPago;

    public Voo(String numeroVoo, String origem, String destino, int assentosDisponiveis, double precoPassagem) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.assentosDisponiveis = assentosDisponiveis;
        this.precoPassagem = precoPassagem;
    }

    public String getNumeroVoo() { return numeroVoo; }
    public void setNumeroVoo(String numeroVoo) { this.numeroVoo = numeroVoo; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public int getAssentosDisponiveis() { return assentosDisponiveis; }

    public double getPrecoPassagem() { return precoPassagem; }

    public boolean verificarDisponibilidade(int quantidadeAssentos) {
        return quantidadeAssentos > 0 && assentosDisponiveis >= quantidadeAssentos;
    }

    public boolean realizarReserva(int quantidadeAssentos) {
        if (!verificarDisponibilidade(quantidadeAssentos)) {
            System.out.println("Reserva não realizada: assentos insuficientes no voo " + numeroVoo);
            return false;
        }
        assentosDisponiveis -= quantidadeAssentos;
        assentosReservados += quantidadeAssentos;
        System.out.println("Reserva realizada: " + quantidadeAssentos + " assento(s) no voo " + numeroVoo);
        return true;
    }

    public double realizarPagamento(String tipoViagem, boolean pontosTuristicos) {
        if (assentosReservados == 0) {
            System.out.println("Nenhuma reserva para pagar. Realize a reserva primeiro.");
            return 0;
        }
        double valorPorAssento = precoPassagem;
        if (tipoViagem.equalsIgnoreCase("ida e volta")) {
            valorPorAssento *= 2;
        } else if (!tipoViagem.equalsIgnoreCase("ida")) {
            System.out.println("Tipo de viagem inválido. Use \"ida\" ou \"ida e volta\".");
            return 0;
        }
        if (pontosTuristicos) {
            valorPorAssento += TAXA_PONTOS_TURISTICOS;
        }
        this.tipoViagem = tipoViagem;
        this.pontosTuristicos = pontosTuristicos;
        this.valorPago = valorPorAssento * assentosReservados;
        return valorPago;
    }

    public void imprimirPassagem() {
        System.out.println("========== PASSAGEM ==========");
        System.out.println("Voo: " + numeroVoo);
        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);
        System.out.println("Assentos reservados: " + assentosReservados);
        System.out.println("Tipo de viagem: " + (tipoViagem != null ? tipoViagem : "não definido"));
        System.out.println("Pontos turísticos: " + (pontosTuristicos ? "Sim" : "Não"));
        System.out.printf("Valor pago: R$ %.2f%n", valorPago);
        System.out.println("==============================");
    }

    @Override
    public String toString() {
        return String.format("Voo %s | %s -> %s | Assentos disponíveis: %d | R$ %.2f",
                numeroVoo, origem, destino, assentosDisponiveis, precoPassagem);
    }
}
