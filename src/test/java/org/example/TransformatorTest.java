package org.example;

import org.example.domain.Pessoa;
import org.example.domain.PessoaDTO;
import org.example.refl.Transformator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Joaquim", "02545678981");
    PessoaDTO dto = new PessoaDTO("Guilher", "02345678914");

    @Test
    @DisplayName("Teste de reflect de Pessoa para pessoaDTO")
    public void shouldTransformPessoa() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    @DisplayName("Teste de reflect de PessoaDTO para pessoa")
    public void shouldTransformPessoaDTO() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        Pessoa pessoa1 = transformator.transform(dto);

        Assertions.assertInstanceOf(Pessoa.class, pessoa1);
        Assertions.assertEquals(dto.getNome(), pessoa1.getNome());
        Assertions.assertEquals(dto.getCpf(), pessoa1.getCpf());
    }
}
