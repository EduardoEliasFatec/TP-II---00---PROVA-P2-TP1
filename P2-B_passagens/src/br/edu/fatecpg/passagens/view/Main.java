package br.edu.fatecpg.passagens.view;

import br.edu.fatecpg.passagens.model.Aeroporto;
import br.edu.fatecpg.passagens.model.Voo;

public class Main {
    public static void main(String[] args) {

        Voo voo1 = new Voo("AD4050", "São Paulo", "Recife", 10, 800.00);
        Voo voo2 = new Voo("LA3302", "Santos", "Salvador", 2, 650.00);
        Aeroporto aeroporto = new Aeroporto();

        aeroporto.adicionarVoo(voo1);
        aeroporto.adicionarVoo(voo2);
        System.out.println("=== Voos disponíveis ===");
        aeroporto.exibirVoos();

        Voo escolhido = aeroporto.buscarVoo("AD4050");

        System.out.println("\nHá 3 assentos? " + escolhido.verificarDisponibilidade(3));
        if (escolhido.realizarReserva(3)) {
            double total = escolhido.realizarPagamento("ida e volta", true);
            System.out.printf("Total pago: R$ %.2f%n%n", total);
            escolhido.imprimirPassagem();
        }

        voo2.realizarReserva(5);

        aeroporto.removerVoo("LA3302");
        System.out.println("\n=== Após remover o voo LA3302 ===");
        aeroporto.exibirVoos();
    }
}
