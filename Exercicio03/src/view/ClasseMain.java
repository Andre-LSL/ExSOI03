package view;
import java.util.Random;
import controller.VetorThread;

public class ClasseMain {
    public static void main (String [] args) {
        int[] vetor = new int[1000];
        int valorNumerico = 0;
        Random m = new Random();
        int limite = vetor.length;
        for (int ctdr = 0; ctdr < limite; ctdr++) {
            vetor[ctdr] = m.nextInt(100) + 1;
        }

        for(int i = 0; i < 3; i++) {
            valorNumerico = m.nextInt(20);
            System.out.println("Valor numerico respectivamente: " + valorNumerico);
            VetorThread t = new VetorThread(vetor, valorNumerico);
            t.start();
        }
    }
}
