package org.example.java8.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> pList =
                new ArrayList<>(
                List.of(
                 new Person("김찬혁", 27)
                ,new Person("김건우", 33)
                ,new Person("이길환", 25)
                ,new Person("박광해", 12)
                ,new Person("김민석", 17)
                ,new Person("유영재", 21)
                ,new Person("정재민", 24)
                ,new Person("고준휘", 37)
        ));

//        pList.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//               // return o1.compareTo(o2);
//               // return o1.getAge() - o2.getAge();
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

//        pList.sort((o1, o2) ->o1.getAge()-o2.getAge());

        pList.sort(Comparator.comparing(Person::getName));
        pList.sort(Comparator.comparing(Person::getName).reversed());

        System.out.println(pList);
    }
}
