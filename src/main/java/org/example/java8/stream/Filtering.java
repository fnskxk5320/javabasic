package org.example.java8.stream;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.example.java8.stream.Dish.*;

public class Filtering {
    public static void main(String[] args) {

        //stream의 filter : 리턴 조건에 맞는 데이터만 필터링
        // 요리 목록 중에 채식주의자가 먹을 수 있는 음식만 필터링해주세용
        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        for (Dish vegearianDish : vegetarianDishes) {
            System.out.println(vegearianDish);
        }

        vegetarianDishes.forEach(System.out::println);
    }
}
