package org.example;


public class Main {
    public static void main(String[] args) {
        PerceptronDuasEntradas perceptronDuasEntradas = new PerceptronDuasEntradas();
        int ativacao = perceptronDuasEntradas.funcaoDeAtivacao();
        boolean ativado = ativacao == 1 ? true : false;

        System.out.println("Aticacao do neuronio " + ativado);

    }
}