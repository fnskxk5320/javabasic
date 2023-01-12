package org.example.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.example.java8.stream.Dish.*;

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

    // 요리 목록 중에 육류이면서 600칼로리 미만인 요리만 필터링


    public static void main(String[] args) {
        List<String> dishName1 = getHealthDishName2(menu);
        System.out.println(dishName1);

        /*
        Dish.menu.stream().filter(d -> d.getType() == Dish.Type.MEAT)
                .filter(d -> d.getCalorie() < 600)
                .forEach(System.out::println);
         */

        menu.stream()
                .filter(dish -> dish.getType() == Type.MEAT && dish.getCalorie() < 600)
                .collect(toList())
                .forEach(System.out::println);
        List<Integer> nums = List.of(1,2,1,3,3,2,4,4,3,6);

        // nums 리스트에서 짝수만 필터링한 후 중복을 제거해주세요.
        nums.stream().filter(n -> n%2==0).distinct().collect(toList()).forEach(System.out::println);

        System.out.println("============================================");

        //원하는 개수만 필터링하기
        //칼로리가 300칼로리보다 큰 요리중에 처음 발견된 3개만 필터링

        menu.stream().filter(d -> d.getCalorie() > 300).limit(3).collect(toList()).forEach(System.out::println);

        //요소 생략해서 필터링
        //칼로리가 300 칼로리보다 큰 요리 중에 처음 2개는 생략하고 필터링

        System.out.println("============================================");

        menu.stream().filter(d -> d.getCalorie() > 300)
                .skip(2)
                .collect(toList())
                .forEach(System.out::println);

        //스트림을 사용해서 처음 등장하는 고기 요리 2개를 필터링하세요

        System.out.println("============================================");
        menu.stream().filter(d -> d.getType()==Type.MEAT)
                .limit(2).collect(toList())
                .forEach(System.out::println);

    }
}
