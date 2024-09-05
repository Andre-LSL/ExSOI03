package controller;

public class VetorThread extends Thread {
    private int valor;
    private int[] vetor;

    public VetorThread (int [] vetor, int valor) {
        this.vetor = vetor;
        this.valor = valor;
    }

    public void run() {
        double TempoInicial = 0, TempoFinal = 0, TempoTotal = 0;
        if ((valor % 2) == 0 ) {
            TempoInicial = System.nanoTime();
            for (int i = 0 ; i < vetor.length; i++) {}
            TempoFinal = System.nanoTime();
        }   else {
            TempoInicial = System.nanoTime();
            for (int i : vetor) {}
            TempoFinal = System.nanoTime();
        }
        TempoTotal = TempoFinal - TempoInicial;
        TempoTotal = TempoTotal * Math.pow(10, 9);
        System.out.println("Tempo em segundos: " + TempoTotal);
    }
}
