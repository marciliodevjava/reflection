package org.example.domain;

public class Pessoa {
    private Long id;
    private String nome;
    private String cpf;

    public Pessoa(Integer id, String nome, String cpf) {
        this.id = Long.valueOf(id);
        this.nome = nome;
        this.cpf = cpf;
    }

    public Pessoa(){
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "nome: %s\ncpf: %s\n".formatted(this.nome, this.cpf);
    }
}
