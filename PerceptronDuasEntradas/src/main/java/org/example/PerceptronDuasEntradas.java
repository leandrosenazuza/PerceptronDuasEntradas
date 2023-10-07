package org.example;

public class PerceptronDuasEntradas {

    Dados dados = new Dados();

    Pesos pesos = new Pesos();

    Double bias = -0.5;

    public double calculoU(){
        double u = 0.0;


        u = dados.x1[0]*pesos.w1 + dados.x2[0]*pesos.w2 - bias;

        return u;
    }





}
