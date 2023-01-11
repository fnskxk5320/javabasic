package org.example.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static org.example.java8.lambda.FilteringApple.*;

public class Main {

    // 무게 100 이상 내부 클래스
    public static class LightApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() <= 100;
        }
    }

    public static void main(String[] args) {

        List<Apple> appleList = List.of(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.RED),
                new Apple(78, Color.RED),
                new Apple(250, Color.BLUE),
                new Apple(48, Color.BLUE),
                new Apple(125, Color.GREEN),
                new Apple(111, Color.BLUE),
                new Apple(88, Color.RED),
                new Apple(64, Color.GREEN),
                new Apple(179, Color.GREEN));
        List<Apple> greenApples
                = FilteringApple.filterGreenApples(appleList);

        System.out.println("===== 녹색 사과 필터링 =====");
        for (Apple greenApple : greenApples) {
            System.out.println(greenApple);

        }

        System.out.println("===== 빨간 사과 필터링 =====");
        List<Apple> wantColorApples = FilteringApple.filterAppleByColor(appleList, Color.RED);
        for (Apple wantColorApple : wantColorApples) {
            System.out.println(wantColorApple);
        }
/**
        System.out.println("===== 원하는 조건으로 필터링 =====");
        // 파란 사과 필터링
        List<Apple> blueApples = filterApples(appleList, new BlueApplePredicate());
        for (Apple wantColorApple : blueApples) {
            System.out.println(wantColorApple);
        }

        System.out.println("===== 원하는 조건으로 필터링 2 =====");
        // 무게가 100그램 이하인 사과 필터링 (내부 클래스)
        List<Apple> hundredApples = filterApples(appleList, new LightApplePredicate());
        for (Apple wantWeightApple : hundredApples) {
            System.out.println(wantWeightApple);
        }

        System.out.println("===== 원하는 조건으로 필터링 3 =====");
        // 무게 100 이상 (익명 클래스)
        List<Apple> weightApples = filterApples(appleList, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 100;
            }
        });
        for (Apple wantWeightApple : weightApples) {
            System.out.println(wantWeightApple);
        }

        System.out.println("===== 원하는 조건으로 필터링 4 =====");
        // 녹색 사과만 필터링 (람다 - 인터페이스 추상메서드가 단 하나일 것)
        // 람다가 오버라이딩하는 메서드가 단 한 줄일 경우 중괄호 생략 가능
        // 그 한 줄이 리턴문이면 return 키워드 생략가능
        // 파라미터가 단 한 개라면 소괄호 생략 가능
        List<Apple> greenApples2 = filter(appleList, apple ->
                apple.getColor() == Color.GREEN);
        for (Apple wantWeightApple : greenApples2) {
            System.out.println(wantWeightApple);
        }

        System.out.println("===== 원하는 조건으로 필터링 4 =====");
        // 빨간색 사과면서 100그램 이상의 사과만 필터링
        List<Apple> selectApples2 = filter(appleList, apple ->
                apple.getColor()==Color.RED && apple.getWeight()>=100);
        for (Apple wantWeightApple : selectApples2) {
            System.out.println(wantWeightApple);
        }
*/
        System.out.println("===== 원하는 조건으로 필터링 5 =====");
        List<Apple> genericApple = filter(appleList, apple -> apple.getColor() == Color.RED);
        for (Apple wantWeightApple : genericApple) {
            System.out.println(wantWeightApple);
        }

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        List<Integer> eventNumbers = filter(numbers, n -> n%2 ==0);
        for (Integer n : eventNumbers) {
            System.out.println(n);
        }

        /**
         * 리스트와 변경조건을 전달하면 리스트 내부의 값을 변경조건에 따라
         * 반환한 뒤 반환하는 map이라는 메서드를 구현해보세요
         *
         * ex) map(appleList, apple -> apple.setColor(RED))
         *
         *      => 리스트 안의 모든 사과가 빨강색으로 변해야 한다.
         */

        System.out.println("===과제 출력===");
        List<Apple> mapApple = change(appleList, apple -> apple.setColor(Color.RED));
        for (Apple wantWeightApple : mapApple) {
            System.out.println(wantWeightApple);
        }

        List<Color> colorList = map(appleList, Apple::getColor);
        System.out.println("appleColor = " + colorList);

        List<AppleInfo> appleInfos = map(appleList, a-> new AppleInfo(a.getColor(), a.getWeight()));
        System.out.println("appleInfo = " + appleInfos);
    }

    @Getter @NoArgsConstructor
    @ToString @AllArgsConstructor
    public static class AppleInfo {
        private Color color;
        private int weight;


    public AppleInfo(Apple apple) {
        this.color = apple.getColor();
        this.weight = apple.getWeight();
    }
    }
}
