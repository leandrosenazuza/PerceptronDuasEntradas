package org.example;

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

    public double calculoU(){
        epoca++;
        System.out.println("epoca: " + this.epoca);
        System.out.println("w1: " + pesos.w1);
        System.out.println("w2: " + pesos.w2);
        System.out.println("bias: " + bias);

        u = (dados.x1[1]*pesos.w1 + dados.x2[1]*pesos.w2) + bias;

        System.out.println("u: " + u);
        return u;
    }

    /**
     * Se a saída do neurônio for igual a saída desejada, ele será ativado.
     *
     *
     * * */
    public void executar(){

        double u = calculoU();

        this.y1 = funcaoDeAtivacao(u);
        boolean ativado = funcaoDeAtivacao(u) == dados.y[1] ? true : false;

        System.out.println("Ativacao: " + ativado);

        if(!ativado){
            System.out.println("y1: " + dados.y[1]);
            this.pesos.w1 = calculoNovoPeso(this.dados.y[1], this.dados.x1[1]) + this.pesos.w1;
            System.out.println("novo w1: " + this.pesos.w1);
            this.pesos.w2 = calculoNovoPeso(this.dados.y[1], this.dados.x2[1]) + this.pesos.w2;
            System.out.println("novo w2: " + this.pesos.w1);
        }

        u = calculoU();

        boolean ativado2 = funcaoDeAtivacao(u) == dados.y[1] ? true : false;

        System.out.println("Ativacao: " + ativado2);
    }

    /**
     * Calculo do novo peso
     *
     *  deltaWi = n (Yi - yi)xi
     *  O erro portanto é a taxa de aprendizado vezes o valor desejado menos o valor obtido multiplicado pela entrada
     * * */
    public double calculoNovoPeso(double Yi, double xi){

        System.out.println("epoca: " + this.epoca);

        System.out.println("n: " + this.n);

        System.out.println("Yi: " + Yi);

        System.out.println("yi: " + this.y1);

        System.out.println("xi: " + xi);

        double delta = this.n*(Yi - this.y1)*xi;

        System.out.println("Novo peso delta: " + delta);
        return delta;
    }




}
