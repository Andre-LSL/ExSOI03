package controller;

public class ThreadId extends Thread {
    public ThreadId() {
        super();
    }

    public void run() {
        int tid = (int) threadId();
        System.out.println("#"+tid);
    }


}
