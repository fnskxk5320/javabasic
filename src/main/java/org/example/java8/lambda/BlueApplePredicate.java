package org.example.java8.lambda;

public class BlueApplePredicate implements  ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor() == Color.BLUE;
    }
}
