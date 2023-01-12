package org.example.java8.stream.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).

        transactions.stream().filter(t -> t.getYear() == 2021)
                .sorted(Comparator
                .comparing(Transaction::getValue))
                .sorted(Comparator.comparing(v -> v.getValue()))
                .collect(Collectors.toList())
                .forEach(x1 -> System.out.println(x1.getValue()));

        // 연습 2: 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
        System.out.println("======================================");
        transactions.stream().map(s -> s.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x));

        System.out.println("======================================");
        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 이름순으로 오름차정렬.

        /*traders.stream().filter(t->t.getCity()
                .equals("Cambridge"))
                .sorted(Comparator.comparing(n->n.getName()))
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x.getName()));
        */

        transactions.stream().map(t-> t.getTrader())
                        .filter(t -> t.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(Comparator.comparing(x->x.getName()))
                        .collect(Collectors.toList())
                        .forEach(x1 -> System.out.println(x1.getName()));
        System.out.println("======================================");

        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환
        List<Trader> traders = List.of(raoul, brian, mario, alan);
        traders.stream()
                .sorted(Comparator.comparing(n->n.getName())) // 정렬 리스트 대상이 String이나 숫자타입이면 Comparator를 안써도 정렬
                .forEach(x -> System.out.println(x.getName()));


        System.out.println("======================================");
        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인
        boolean isMilan = traders.stream()
                .anyMatch(t -> t.getCity().equalsIgnoreCase("Milan"));

        System.out.println("밀란 거주 거래자 여부 : " + isMilan);

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력
        int cambridgeTranSum = transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .mapToInt(t -> t.getValue())
                .sum();

        System.out.println("캠브릿지에 사는 거래자의 모든 거래액 합 : " + cambridgeTranSum);
        // 연습 7: 모든 거래에서 최고 거래엑은 얼마인가?
        int max = transactions.stream()
                .mapToInt(t -> t.getValue())
                .max().getAsInt();
        System.out.println("최고 거래액 : " + max);

        // 연습 8: 가장 작은 거래액을 가진 거래정보 탐색
        Optional<Transaction> minValueTrans = transactions.stream()
                .min(Comparator.comparing(t -> t.getValue()));

        minValueTrans.ifPresent(s -> System.out.println(s));
    }
}
