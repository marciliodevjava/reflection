package org.example.repository;

import org.example.domain.Pessoa;

public class PessoaRepository {

    public Pessoa list(){
        return new Pessoa(1, "João", "1234");
    }
}
