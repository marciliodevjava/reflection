package org.example.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Transformator {

    public <I, O> O transform(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> source = input.getClass();
        String targetClassName = source.getName() + "DTO";
        Class<?> target = Class.forName(targetClassName);

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(targetField -> {
                    sourceField.setAccessible(true);
                    if (validate(sourceField, targetField)){
                        targetField.setAccessible(true);
                        try {
                            targetField.set(targetClass, sourceField.get(input));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    };
                }));

        return targetClass;
    }

    private Boolean validate(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName()) && sourceField.getType().equals(targetField.getType())) {
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            return true;
        }
        return false;
    }
}
