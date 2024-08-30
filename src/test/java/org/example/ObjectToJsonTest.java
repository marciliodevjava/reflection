package org.example;

import org.example.domain.Pessoa;
import org.example.refl.ObjectToJson;

public class ObjectToJsonTest {

    static Pessoa pessoa = new Pessoa(1, "Gustavo", "02596345681");

    public static void main(String... x) {
        ObjectToJson objectToJson = new ObjectToJson();
        System.out.println(objectToJson.transform(pessoa));
    }
}
