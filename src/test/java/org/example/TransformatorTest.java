package org.example;

import org.example.domain.Endereco;
import org.example.domain.Pessoa;
import org.example.domain.PessoaDTO;
import org.example.refl.Transformator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Joaquim", "02545678981");
    PessoaDTO dto = new PessoaDTO("Guilher", "02345678914");
    Endereco endereco = new Endereco("Rua dos almofadinha", 3);

    @Test
    @DisplayName("Teste de reflect de Pessoa para pessoaDTO")
    public void shouldTransformPessoa() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        assertInstanceOf(PessoaDTO.class, pessoaDTO);
        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    @DisplayName("Teste de reflect de PessoaDTO para pessoa")
    public void shouldTransformPessoaDTO() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        Pessoa pessoa1 = transformator.transform(dto);

        Assertions.assertAll("EXECUTA TESTES",
                () -> assertInstanceOf(Pessoa.class, pessoa1),
                () -> assertEquals(dto.getNome(), pessoa1.getNome()),
                () -> assertEquals(dto.getCpf(), pessoa1.getCpf()));
    }

    @Test
    @DisplayName("Passando a class Object para receber uma class Pessoa, Esperando um ClassNotFoundException")
    public void shuoldNotTransforme() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            Object obj = transformator.transform(endereco);
        });
    }
}
