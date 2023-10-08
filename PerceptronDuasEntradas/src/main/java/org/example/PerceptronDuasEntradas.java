package org.example;

import java.util.ArrayList;
import java.util.Iterator;

public class PerceptronDuasEntradas {

    double u = 0.0;
    Dados dados = new Dados();

    Pesos pesos = new Pesos();

    /**
     * @bias é o limiar de ativação
     * */
    Double bias = -0.5;

    /**
     * @n taxa de aprendizado
     * */
    Double n = 0.5;

    int y1 = 0;
    int epoca = 0;


    /**
     * Está sendo utilizado uma função de ativação degrau.
     * g(u) = 1, se u >= 0
     * g(u) = 0, se u < 0
     * */

    public int funcaoDeAtivacao(double u){
        if(u >= 0) return 1;
        else return 0;
    }

    public double calculoU(int i){
        epoca++;
        return  (dados.x1[i]*pesos.w1 + dados.x2[i]*pesos.w2) + bias;
    }

    /**
     * Se a saída do neurônio for igual a saída desejada, ele será ativado.
     *
     *
     * * */
    public void executar(){
        this.apresentacao();
        int i = 0;

        while(i < dados.y.length){
            boolean ativado = false;
            double u = calculoU(i);
            double gu = funcaoDeAtivacao(u);
            if(gu == dados.y[i]){
                ativado = true;
                System.out.println("&----------------------------------------&");
                System.out.println("Foi ativado? " + (ativado ? "Sim!" : "Não!") + " Valor objetivado: y= " + dados.y[i]);
                System.out.println("&----------------------------------------&");
                System.out.println("\n");
            }
            if(!ativado){
                System.out.println("================> y[" + i + "]: " + dados.y[i] + "<================");
                this.pesos.w1 = calculoNovoPeso(this.dados.y[i], this.dados.x1[i], i, gu) + this.pesos.w1;
                this.pesos.w2 = calculoNovoPeso(this.dados.y[i], this.dados.x2[i], i, gu) + this.pesos.w2;
                System.out.println("\n");
            }else{
                i++;
            }

        }

        System.out.println("*----------------------------------*");
        System.out.println("Os pesos final foram: ");
        System.out.println("w1: " + pesos.w1);
        System.out.println("w2: " + pesos.w2);
        System.out.println("bias: " + this.bias);
        System.out.println("Taxa de aprendizado: " + this.n);
        System.out.println("O modelo final fica: " + "u = " + pesos.w1 + "*x1 + " + pesos.w2 + "*x2 + (" + this.bias + ")");
        System.out.println("*----------------------------------*");
        System.out.println("\n");



    }

    private void apresentacao() {
        System.out.println("O presente programa tem por objetivo utilizar de uma Rede Neural Perceptron, para criar um modelo para uma função degrau, a partir da tabela verdade de uma porta lógica OR.");
        System.out.println("São os dados: ");
        System.out.println("$============$");
        System.out.println("x1 | x2 | y");
        System.out.println(" 0 |  0 | 0");
        System.out.println(" 0 |  1 | 1");
        System.out.println(" 1 |  0 | 1");
        System.out.println(" 1 |  1 | 1");
        System.out.println("$============$");
    }

    /**
     * Calculo do novo peso
     *
     *  deltaWi = n (Yi - yi)xi
     *  O erro portanto é a taxa de aprendizado vezes o valor desejado menos o valor obtido multiplicado pela entrada
     * * */
    public double calculoNovoPeso(double Yi, double xi, int i, double gu){

        System.out.println("===============================================");
        System.out.println("epoca: " + this.epoca);

        System.out.println("n: " + this.n);

        System.out.println("Yi: " + this.dados.y[i]);

        System.out.println("yi: " + gu);

        System.out.println("xi: " + xi);

        double delta = this.n*(Yi - gu)*xi;

        System.out.println("Novo peso delta: " + delta);
        System.out.println("===============================================");
        System.out.println("\n");
        return delta;
    }




}
