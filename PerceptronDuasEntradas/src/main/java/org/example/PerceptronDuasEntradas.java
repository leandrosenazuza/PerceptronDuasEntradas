package org.example;

public class PerceptronDuasEntradas {

    Dados dados = new Dados();

    Pesos pesos = new Pesos();

    /**
     * @bias é o limiar de ativação
     * */
    Double bias = -0.5;

    /**
     * Está sendo utilizado uma função de ativação degrau.
     * g(u) = 1, se u >= 0
     * g(u) = 0, se u < 0
     * */

    public int funcaoDeAtivacao(){
        double u = calculoU();
        if(u >= 0) return 1;
        else return 0;
    }

    public double calculoU(){
        double u = 0.0;


        u = (dados.x1[0]*pesos.w1 + dados.x2[0]*pesos.w2) + bias;

        return u;
    }





}
