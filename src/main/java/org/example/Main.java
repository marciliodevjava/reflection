package org.example;

import org.example.domain.Pessoa;
import org.example.dto.PessoaDTO;
import org.example.refl.Transformator;
import org.example.repository.PessoaRepository;
import org.example.service.PessoaService;

import java.lang.reflect.InvocationTargetException;

public class Main {
    private static final String INICIO = "INICIANDO SERVICO.";
    private static final String FINALIZANDO = "FINALIZANDO SERVIÇO.";

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        System.out.println(INICIO);
        PessoaDTO dto = new PessoaService().list();
        System.out.println(dto);
        System.out.println(FINALIZANDO);
    }
}