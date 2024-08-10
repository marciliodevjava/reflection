package org.example;

import org.example.service.PessoaService;

public class Main {
    private static final String INICIO = "INICIANDO SERVICO.";
    private static final String FINALIZANDO = "FINALIZANDO SERVIÇO.";

    public static void main(String[] args) {
        System.out.println(INICIO);
        new PessoaService().list();
        System.out.println(FINALIZANDO);
    }
}