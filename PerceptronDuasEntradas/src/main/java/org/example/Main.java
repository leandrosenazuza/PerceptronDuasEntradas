package org.example;


public class Main {
    public static void main(String[] args) {
        PerceptronDuasEntradas perceptronDuasEntradas = new PerceptronDuasEntradas();
        double u = perceptronDuasEntradas.calculoU();

        System.out.println("u calculado " + u);

    }
}