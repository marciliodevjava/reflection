package org.example.service;

import org.example.domain.Pessoa;
import org.example.dto.PessoaDTO;
import org.example.repository.PessoaRepository;

public class PessoaService {
    private final String MESSAGE_CREATE = "CRIANDO O OBJETO PESSOA";
    private final String MESSAGE_FINAL = "RETORNANDO O OBJETO PESSOA";

    public PessoaDTO list() {
        System.out.println(MESSAGE_CREATE);
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO pessoaDto = new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
        System.out.println(MESSAGE_FINAL);
        return pessoaDto;
    }
}
