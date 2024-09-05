package controller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Threads extends Thread {
    private int identificador;

    public Threads(int identificador) {
        this.identificador = identificador;
    }

    private String obterSO() {
        return System.getProperty("os.name");
    }

    @Override
    public void run() {
        executarPing(identificador);
    }

    public void executarPing(int identificador) {
        if (obterSO().contains("Linux")) {
            try {
                String comando = "";
                String host = "";

                if (identificador == 0) {
                    comando = "ping -4 -c 10 www.uol.com.br";
                    host = "uol";
                } else if (identificador == 1) {
                    comando = "ping -4 -c 10 www.google.com.br";
                    host = "google";
                } else if (identificador == 2) {
                    comando = "ping -4 -c 10 www.terra.com.br";
                    host = "terra";
                }

                Process processo = Runtime.getRuntime().exec(comando);
                InputStream fluxo = processo.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);

                String linhaAtual = buffer.readLine();
                int contador = 0;

                while (linhaAtual != null) {
                    if (linhaAtual.contains("seq")) {
                        contador++;
                        String[] partes = linhaAtual.split("=");
                        System.out.println(host + " " + contador + ": " + partes[3]);
                    } 
                    if (linhaAtual.contains("transmitted")) {
                        String[] partesFinal = linhaAtual.split(",");
                        System.out.println("Média de tempo de resposta do " + host + ": " + partesFinal[3]);
                    }
                    linhaAtual = buffer.readLine();
                }

                buffer.close();
                leitor.close();
                fluxo.close();
                
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            System.out.println("Sistema não é Linux.");
        }
    }
}
