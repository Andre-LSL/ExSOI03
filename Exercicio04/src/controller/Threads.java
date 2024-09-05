package controller;

import java.util.Random;

public class Threads extends Thread {
	
	private String sapoNome;
	private int puloMaximo;
	private static int posicaoFinal = 0;
	
	public Threads(String sapoNome, int puloMaximo) {
		this.puloMaximo = puloMaximo;
		this.sapoNome = sapoNome;
	}
	
	@Override
	public void run() {
		iniciarCorrida();
	}
	
	private void iniciarCorrida() {
		
		int idThread = (int) threadId();
		
		Random geradorAleatorio = new Random();
		int distanciaTotal = 100;
		int distanciaAtual = 0;
		long tempoInicio = System.nanoTime();
		
		while(distanciaAtual < distanciaTotal) {
			int salto = geradorAleatorio.nextInt(puloMaximo + 1);
			distanciaAtual += salto;
            System.out.println(sapoNome + " pulou " + salto + " metros. Distância atual: " + distanciaAtual + " metros.");
            try {
            	Thread.sleep(500);
            } catch(Exception ex) {
            	System.err.println(ex.getMessage());
            }
		}
		long tempoFim = System.nanoTime();
		double tempoTotal = (tempoFim - tempoInicio) / Math.pow(10, 9);
		posicaoFinal++;
		System.out.println(sapoNome + " (Thread ID: " + idThread + ") chegou na posição " + posicaoFinal + "! Tempo total: " + tempoTotal + " segundos.");
	}
}

