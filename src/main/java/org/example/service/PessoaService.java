package org.example.service;

import org.example.domain.Pessoa;
import org.example.dto.PessoaDTO;
import org.example.repository.PessoaRepository;

public class PessoaService {

    public PessoaDTO list() {
        Pessoa pessoa = new PessoaRepository().list();
        PessoaDTO pessoaDto = new PessoaDTO(pessoa.getNome(), pessoa.getCpf());
        return pessoaDto;
    }
}
