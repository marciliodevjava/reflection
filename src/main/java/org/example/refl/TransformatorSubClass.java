package org.example.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class TransformatorSubClass {

    public <I, O> O transformSubClass(I input) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> source = input.getClass();
        Class<?> target = Class.forName(search(source));

        O targetClass = (O) target.getDeclaredConstructor().newInstance();

        Field[] sourceFields = source.getDeclaredFields();
        Field[] targetFields = target.getDeclaredFields();

        Arrays.stream(sourceFields).forEach(sourceField ->
                Arrays.stream(targetFields).forEach(targetField -> {
                    sourceField.setAccessible(true);
                    if (validate(sourceField, targetField)) {
                        targetField.setAccessible(true);
                        try {
                            Object sourceValue = sourceField.get(input);
                            Object targetValue;

                            if (sourceField.getType().isPrimitive() || sourceField.getType().equals(String.class)) {
                                targetValue = sourceValue;
                            } else {
                                targetValue = transformSubClass(sourceValue);
                            }
                            targetField.set(targetClass, sourceField.get(input));
                        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException |
                                 NoSuchMethodException | InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                    ;
                }));

        return targetClass;
    }

    private String search(Class<?> source) {
        if (source.getName().contains("DTO")) return source.getName().replace("DTO", "");
        return source.getName().concat("DTO");
    }

    private Boolean validate(Field sourceField, Field targetField) {
        if (sourceField.getName().equals(targetField.getName()) && sourceField.getType().equals(targetField.getType())) {
            return true;
        }
        return false;
    }
}

