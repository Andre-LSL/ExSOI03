package view;
import controller.Threads;
public class ClasseMain {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Threads t = new Threads(i);
            t.start();
        }
    }
}