package br.edu.fatecpg.passagens.model;

import java.util.ArrayList;

public class Aeroporto {
    private ArrayList<Voo> voos;

    public Aeroporto() {
        this.voos = new ArrayList<>();
    }

    public void adicionarVoo(Voo voo) {
        if (voo == null) {
            System.out.println("Voo inválido.");
            return;
        }
        if (buscarVoo(voo.getNumeroVoo()) != null) {
            System.out.println("Já existe o voo " + voo.getNumeroVoo());
            return;
        }
        voos.add(voo);
    }

    public boolean removerVoo(String numeroVoo) {
        Voo v = buscarVoo(numeroVoo);
        if (v == null) {
            return false;
        }
        return voos.remove(v);
    }

    public Voo buscarVoo(String numeroVoo) {
        for (Voo v : voos) {
            if (v.getNumeroVoo().equalsIgnoreCase(numeroVoo)) {
                return v;
            }
        }
        return null;
    }

    public void exibirVoos() {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo disponível.");
            return;
        }
        for (Voo v : voos) {
            System.out.println(v);
        }
    }
}
