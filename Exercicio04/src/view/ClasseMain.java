package view;
import controller.Threads;

public class ClasseMain {
        public static void main(String[] args) {
            for(int i = 0; i < 5; i++) {
                Threads sapo = new Threads("Sapo " + (i+1), 10);
                sapo.start();
            }
        }
    
    }
