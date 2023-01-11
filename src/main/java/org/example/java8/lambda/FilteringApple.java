package org.example.java8.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilteringApple {

    /**
     * @solution - try1 : 녹색사과를 필터링하는 메서드를 만들어야 함
     */

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @solution - try 2 : 색상을 파라미터화 한다.
     */

    public static List<Apple> filterAppleByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * @solution - try 3 : 동작을 파라미터화 한다. - 추상적 조건으로 필터링
     * @problem
     * - 과일이 사과가 아니라 오렌지면?
     * - 과일이 아니라 가전제품이면?
     */

    public static <T>List<T> filter(List<T> inventory, GenericPredicate<T> t) {
        List<T> result = new ArrayList<>();
        for(T item : inventory) {
            if (t.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T>List<T> change(List<T> inventory, GenericMap<T> t) {
        List<T> result = new ArrayList<>();
        for(T item : inventory) {
            t.map(item) ;
            result.add(item);
        }
        return result;
    }

    public static <T, R> List<R> map(List<T> list, GenericFunction<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R r = mapper.apply(t);
            result.add(r);
        }
        return result;
    }



    /**
     * @solution - try 4 : 제네릭 필터 메서드 생성
     */



}
