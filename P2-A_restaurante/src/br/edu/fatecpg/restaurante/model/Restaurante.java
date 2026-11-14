package br.edu.fatecpg.restaurante.model;

import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Pedido> pedidos;

    public Restaurante() {
        this.pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        if (pedido == null) {
            System.out.println("Pedido inválido.");
            return;
        }
        if (buscarPedido(pedido.getNumero()) != null) {
            System.out.println("Já existe um pedido com o número " + pedido.getNumero());
            return;
        }
        pedidos.add(pedido);
    }

    public boolean removerPedido(int numero) {
        Pedido p = buscarPedido(numero);
        if (p == null) {
            return false;
        }
        return pedidos.remove(p);
    }

    public Pedido buscarPedido(int numero) {
        for (Pedido p : pedidos) {
            if (p.getNumero() == numero) {
                return p;
            }
        }
        return null;
    }

    public void exibirPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
            return;
        }
        for (Pedido p : pedidos) {
            System.out.println(p);
            System.out.println("------------------------------------");
        }
    }
}
