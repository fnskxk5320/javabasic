package org.example.java8.compare;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@ToString @AllArgsConstructor
@EqualsAndHashCode
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    /*
        비교 대상 객체 2개를 전달 받아서
        (this, o)

        비교 대상(o)이 더 크면 음수,
        같으면 0,
        작으면 양수 리턴
    */

    @Override
    public int compareTo(Person o) {
        return this.age-o.getAge();
    }
}
