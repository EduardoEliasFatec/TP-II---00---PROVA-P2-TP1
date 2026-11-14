package br.edu.fatecpg.restaurante.view;

import br.edu.fatecpg.restaurante.model.ItemPedido;
import br.edu.fatecpg.restaurante.model.Pedido;
import br.edu.fatecpg.restaurante.model.Restaurante;

public class Main {
    public static void main(String[] args) {

        ItemPedido pizza = new ItemPedido("Pizza Margherita", 2, 45.90);
        ItemPedido refri = new ItemPedido("Refrigerante 2L", 1, 12.00);
        ItemPedido sobremesa = new ItemPedido("Pudim", 3, 9.50);

        Pedido pedido1 = new Pedido(1, 8.00);
        Pedido pedido2 = new Pedido(2, 0.00);

        Restaurante restaurante = new Restaurante();

        pedido1.adicionarItem(pizza);
        pedido1.adicionarItem(refri);
        pedido1.adicionarItem(sobremesa);
        pedido1.removerItem(sobremesa);
        pedido1.reservarMesa(5);
        System.out.printf("Total do pedido 1: R$ %.2f%n%n", pedido1.calcularTotalPedido());

        pedido2.adicionarItem(sobremesa);
        pedido2.reservarMesa(3);

        restaurante.adicionarPedido(pedido1);
        restaurante.adicionarPedido(pedido2);

        System.out.println("=== Todos os pedidos ===");
        restaurante.exibirPedidos();

        Pedido encontrado = restaurante.buscarPedido(2);
        System.out.println("Busca pedido 2: " + (encontrado != null ? "encontrado" : "não encontrado"));

        restaurante.removerPedido(2);
        System.out.println("\n=== Após remover o pedido 2 ===");
        restaurante.exibirPedidos();
    }
}
