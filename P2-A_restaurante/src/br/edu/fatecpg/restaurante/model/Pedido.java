package br.edu.fatecpg.restaurante.model;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private ArrayList<ItemPedido> itens;
    private double taxaEntrega;
    private int numeroMesa;

    public Pedido(int numero, double taxaEntrega) {
        this.numero = numero;
        this.taxaEntrega = taxaEntrega;
        this.itens = new ArrayList<>();
        this.numeroMesa = 0;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public ArrayList<ItemPedido> getItens() { return itens; }

    public double getTaxaEntrega() { return taxaEntrega; }
    public void setTaxaEntrega(double taxaEntrega) { this.taxaEntrega = taxaEntrega; }

    public int getNumeroMesa() { return numeroMesa; }

    public double calcularTotalPedido() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total + taxaEntrega;
    }

    public void adicionarItem(ItemPedido item) {
        if (item == null) {
            System.out.println("Item inválido.");
            return;
        }
        itens.add(item);
    }

    public boolean removerItem(ItemPedido item) {
        return itens.remove(item);
    }

    public void reservarMesa(int numeroMesa) {
        if (numeroMesa <= 0) {
            System.out.println("Número de mesa inválido.");
            return;
        }
        this.numeroMesa = numeroMesa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(numero);
        sb.append(numeroMesa > 0 ? " | Mesa " + numeroMesa : " | Sem mesa reservada").append("\n");
        if (itens.isEmpty()) {
            sb.append("  (sem itens)\n");
        }
        for (ItemPedido item : itens) {
            sb.append("  - ").append(item).append("\n");
        }
        sb.append(String.format("  Taxa de entrega: R$ %.2f%n", taxaEntrega));
        sb.append(String.format("  TOTAL: R$ %.2f", calcularTotalPedido()));
        return sb.toString();
    }
}
