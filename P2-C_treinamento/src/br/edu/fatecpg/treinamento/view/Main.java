package br.edu.fatecpg.treinamento.view;

import br.edu.fatecpg.treinamento.model.Aluno;
import br.edu.fatecpg.treinamento.model.Treinamento;
import br.edu.fatecpg.treinamento.model.TreinamentoOnline;
import br.edu.fatecpg.treinamento.model.TreinamentoPresencial;

public class Main {
    public static void main(String[] args) {

        Aluno ana = new Aluno("Ana", 9.0, 20);
        Aluno bruno = new Aluno("Bruno", 7.5, 70);
        Aluno carla = new Aluno("Carla", 8.0, 0);

        Treinamento generico = new Treinamento(1, "Prof. Marcos", "Java", true);
        TreinamentoPresencial presencial =
                new TreinamentoPresencial(2, "Prof. Alessandro", "Java", true, "FATEC Praia Grande - Lab 3");
        TreinamentoOnline online =
                new TreinamentoOnline(3, "Profa. Julia", "Python", true, "https://meet.exemplo.com/python");

        generico.definirCargaHoraria(30);
        presencial.definirCargaHoraria(40);
        online.definirCargaHoraria(40);

        presencial.inscreverAluno(ana);
        presencial.inscreverAluno(bruno);
        online.inscreverAluno(carla);

        ana.setNotaFinal(9.5);
        carla.setNotaFinal(8.5);

        Treinamento[] treinamentos = { generico, presencial, online };
        for (Treinamento t : treinamentos) {
            System.out.println();
            t.iniciarTreinamento();
            t.exibirDetalhes();
        }

        System.out.println();
        presencial.reservarSala();
        online.enviarLinkAosAlunos();
    }
}
