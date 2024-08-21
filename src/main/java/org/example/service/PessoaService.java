package org.example.service;

import org.example.domain.Pessoa;
import org.example.domain.PessoaDTO;
import org.example.refl.Transformator;
import org.example.repository.PessoaRepository;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {
    private final String MESSAGE_CREATE_PESSOA = "CRIANDO O OBJETO PESSOA";
    private final String MESSAGE_RETURN_PESSOA = "RETORNANDO O OBJETO PESSOA";
    private final String MESSAGE_CREATE_PESSOA_DTO = "CRIANDO O OBJETO PESSOA DTO";
    private final String MESSAGE_RETURN_PESSOA_DTO = "RETORNANDO O OBJETO PESSOA DTO";

    public PessoaDTO list() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(MESSAGE_CREATE_PESSOA);
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO pessoaDTO = new Transformator().transform(pessoa);
        System.out.println(MESSAGE_RETURN_PESSOA_DTO);
        return pessoaDTO;
    }

    public Pessoa pessoa() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        System.out.println(MESSAGE_CREATE_PESSOA_DTO);
        PessoaDTO pessoaDTO = new PessoaDTO().list();
        Pessoa pessoa = new Transformator().transform(pessoaDTO);
        System.out.println(MESSAGE_RETURN_PESSOA);
        return pessoa;
    }
}
