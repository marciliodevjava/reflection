package org.example.domain;

public class PessoaDTO {
    private String nome;
    private String cpf;

    public PessoaDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public PessoaDTO(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "nome: %s\ncpf: %s\n".formatted(this.nome, this.cpf);
    }

    public PessoaDTO list(){
        return new PessoaDTO("Pedro","02396578948");
    }
}
