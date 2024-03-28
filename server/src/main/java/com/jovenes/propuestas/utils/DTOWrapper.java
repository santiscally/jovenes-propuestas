package com.jovenes.propuestas.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DTOWrapper {


    public static <Y, U> U getDto(Y object, List<String> names, Class<U> dtoClass) throws IllegalAccessException, InstantiationException {
        U dto = dtoClass.newInstance();

        // Obtener todos los campos declarados en la clase Y (Proyect)
        Field[] fields = getAllFields(object.getClass());

        // Copiar los valores de los campos de la clase Y a los campos correspondientes en la clase U (ProyectDTO)
        for (Field field : fields) {
            if (names.contains(field.getName())) {
                // Si el campo está en la lista de campos solicitados
                field.setAccessible(true); // Permitir acceso a campos privados
                Field dtoField = findFieldInHierarchy(dtoClass, field.getName());
                dtoField.setAccessible(true); // Permitir acceso a campos privados
                dtoField.set(dto, field.get(object)); // Copiar el valor del campo de Proyect a ProyectDTO
            }
        }
        return dto;
    }

    private static Field[] getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }

    private static Field findField(Class<?> clazz, String fieldName) {
        try{
            return clazz.getDeclaredField(fieldName);
        }catch (NoSuchFieldException e){
            return null;
        }
    }

    private static Field findFieldInHierarchy(Class<?> clazz, String fieldName) {
        Class<?> currentClass = clazz;
        if (currentClass != null) {
            Field field = findField(currentClass, fieldName);
            if (field != null) {
                return field;
            }else{
                currentClass = currentClass.getSuperclass();
                return findFieldInHierarchy(currentClass, fieldName);
            }
        }
        return null;
    }
}
