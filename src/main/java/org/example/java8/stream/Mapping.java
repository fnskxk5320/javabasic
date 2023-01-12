package org.example.java8.stream;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {
        List<String> dishNames = Dish.menu.stream()
                .map(d -> d.getName())
                .collect(Collectors.toList());

        System.out.println(dishNames.size());
        System.out.println("DishNames = " + dishNames);

        List<String> words = List.of(
                "safari", "chrome", "ms edge", "opera", "firefox");

        List<Integer> strLength = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println(strLength);

        System.out.println("===================================");

        List<Integer> nums = List.of(1,2,3,4,5);
        List<Integer> squares = nums.stream()
                .map(t -> t * t)
                .collect(Collectors.toList());

        System.out.println("squares = " + squares);

        // 요리 목록의 총 칼로리 수 구하기

        int totalCalorie = Dish.menu.stream()
                .mapToInt(c -> c.getCalorie())
                .sum();

        System.out.println("totalCalorie = " + totalCalorie);

        double meatCalorieAverage = Dish.menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .mapToInt(c -> c.getCalorie())
                .average()
                .getAsDouble();

        System.out.println(meatCalorieAverage);


        //meatCalorieAverage.ifPresent(c -> System.out.println(c));

        // 만약 DB에서 특정 게시물의 정보를 조회했는데 게시물이 없으면 null이 반한됌
        // Optional은 자동 null 체크를 지원함 : ifPresent
    }
}
