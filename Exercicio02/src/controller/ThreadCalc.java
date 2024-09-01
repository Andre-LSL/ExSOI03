package controller;

public class ThreadCalc extends Thread {
    private int linha;
    private int[] vetor = new int [5];

    public ThreadCalc(int[] vetor, int linha) {
        this.vetor = vetor;
        this.linha = linha;
    }

    public void run() {
        calculo();
    }

    private void calculo() {
        int resultado = 0;

        for(int i = 0; i < 5; i++) {
            resultado += vetor[i];
        }
        System.out.println("Valor da linha é " + resultado
                          + "\nLinha: " + linha); 
    }
}
