package org.example.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    /*
         요리 목록에서 칼로리가 400 칼로리보다 작은 요리들만 추출해서
         칼로리가 낮은 순서대로 오름차순 정렬한 후
         그 요리의 이름들만 추출해서 리스트로 만들고 싶어요
     */
    //스트림 사용하지 않은 코드
    public static List<String> getHealthDishName(List<Dish> menu) {
        List<Dish> lowCalorieDishes = new ArrayList<>();
        for (Dish dish : menu) {
            if(dish.getCalorie() < 400) {
                lowCalorieDishes.add(dish);
            }
        }
        lowCalorieDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalorie()-o2.getCalorie();
            }
        });

        List<String> dishNames = new ArrayList<>();
        for (Dish lowCaloricDish : lowCalorieDishes) {
            dishNames.add(lowCaloricDish.getName());
        }
        return dishNames;
    }

    //스트림을 사용한 코드

    public static List<String> getHealthDishName2(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getCalorie() < 400)
                .sorted(Comparator.comparing(d -> d.getCalorie()))
                .map(d -> d.getName())
                .collect(toList());
    }
    public static void main(String[] args) {
        List<String> dishName1 = getHealthDishName2(Dish.menu);
        System.out.println(dishName1);

    }
}
