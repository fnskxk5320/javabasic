package org.example.java8.stream.practice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor

public class Trader {
    private final String name;
    private final String city;

    @Override
    public String toString() {
        return String.format("이름 : %s 도시 : %s", name, city);
    }
}
