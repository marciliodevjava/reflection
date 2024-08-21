package org.example.service;

import org.example.domain.Pessoa;
import org.example.domain.PessoaDTO;
import org.example.refl.Transformator;
import org.example.repository.PessoaRepository;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {
    private final String MESSAGE_CREATE = "CRIANDO O OBJETO PESSOA";
    private final String MESSAGE_FINAL = "RETORNANDO O OBJETO PESSOA";

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(MESSAGE_CREATE);
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO pessoaDTO = new Transformator().transform(pessoa);
        System.out.println(MESSAGE_FINAL);
        return pessoaDTO;
    }

    public Pessoa pessoa() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(MESSAGE_CREATE);
        PessoaDTO pessoaDTO = new PessoaDTO().list();
        Pessoa pessoa = new Transformator().transform(pessoaDTO);
        System.out.println(MESSAGE_FINAL);
        return pessoa;
    }
}
