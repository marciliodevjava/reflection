package org.example;

import org.example.domain.Pessoa;
import org.example.refl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Joaquim", "02545678981");

    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        transformator.transform(pessoa);
    }
}
