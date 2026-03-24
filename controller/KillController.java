package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KillController {

    // 1) Método privado que identifica o SO
    private String os() {
        return System.getProperty("os.name").toLowerCase();
    }

    // 2) Listar processos ativos
    public void listaProcessos() {
        String sistema = os();
        String comando = "";

        try {
            if (sistema.contains("win")) {
                comando = "tasklist";
            } else {
                comando = "ps -e";
            }

            Process p = Runtime.getRuntime().exec(comando);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );

            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar processos: " + e.getMessage());
        }
    }

    // 3) Matar processo pelo PID
    public void mataPid(String pid) {
        String sistema = os();
        String comando = "";

        try {
            if (sistema.contains("win")) {
                comando = "taskkill /PID " + pid + " /F";
            } else {
                comando = "kill -9 " + pid;
            }

            Runtime.getRuntime().exec(comando);
            System.out.println("Processo com PID " + pid + " finalizado.");

        } catch (Exception e) {
            System.out.println("Erro ao matar processo: " + e.getMessage());
        }
    }

    // 4) Matar processo pelo nome
    public void mataNome(String nome) {
        String sistema = os();
        String comando = "";

        try {
            if (sistema.contains("win")) {
                comando = "taskkill /IM " + nome + " /F";
            } else {
                comando = "pkill -f " + nome;
            }

            Runtime.getRuntime().exec(comando);
            System.out.println("Processo " + nome + " finalizado.");

        } catch (Exception e) {
            System.out.println("Erro ao matar processo: " + e.getMessage());
        }
    }
}