package org.example.java8.lambda;

@FunctionalInterface
public interface GenericFunction<T, R> {

    R apply(T t);
}
