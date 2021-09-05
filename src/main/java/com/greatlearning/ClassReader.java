package com.greatlearning;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ClassReader to read class information
 */
public class ClassReader {


    /**
     * Get all methods of the class
     *
     * @param c
     * @return
     */
    public String getMethods(Class<?> c) {
        Method[] methods = c.getMethods();
        System.out.println("All Methods: ");
        StringBuilder str = new StringBuilder();
        Arrays.stream(methods).forEach(method -> {
            System.out.println(method);
            str.append(method).append("\n");
        });
        return "Methods: \n" + str;
    }

    /**
     * get class name
     *
     * @param c
     * @return
     */
    public String getClassName(Class<?> c) {
        String className = c.getName();
        System.out.println("Name of the class: " + className);
        return className;

    }

    /**
     * get parent class name
     *
     * @param c
     * @return
     */
    public String getParentClass(Class<?> c) {
        String className = c.getSuperclass().getName();
        System.out.println("Parent class name " + className);
        return className;

    }

    /**
     * get sub class using org.reflections package
     *
     * @param c
     * @return
     */
    public String getSubClass(Class<?> c) {
        Reflections reflections = new Reflections(c.getPackage());
        System.out.println(reflections.getSubTypesOf(c));
        return null;

    }

    /**
     * get all constructors
     *
     * @param c
     * @return
     */
    public String getConstructors(Class<?> c) {
        Constructor[] constructors = c.getConstructors();
        System.out.println("All Constructors: ");

        StringBuilder str = new StringBuilder();
        Arrays.stream(constructors).forEach(constructor -> {
            System.out.println(constructor);
            str.append(constructor).append("\n");
        });
        return "Constructors: \n" + str;
    }

    /**
     * get all fields
     *
     * @param c
     * @return
     */
    public String getDataMembers(Class<?> c) {
        Field[] fields = c.getFields();
        System.out.println("All data members: ");

        StringBuilder str = new StringBuilder();
        Arrays.stream(fields).forEach(field -> {
            System.out.println(field);
            str.append(field).append("\n");
        });
        return "Data members: \n" + str;
    }
}
