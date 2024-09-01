package view;

import java.util.Random;

import controller.ThreadCalc;

public class ClasseMain {
    public static void main (String [] args) {
        int[][] matriz = new int[3][5];
        Random valor = new Random();
        
        for (int L = 0; L < 3; L++) {
            for (int C = 0; C < 5; C++) {
                matriz[L][C] = valor.nextInt(20) + 1;
            }
        }

        for(int ctdr = 0; ctdr < matriz.length; ctdr ++) {
            ThreadCalc th = new ThreadCalc(matriz[ctdr], ctdr);
            th.start();
        }
    }
}
