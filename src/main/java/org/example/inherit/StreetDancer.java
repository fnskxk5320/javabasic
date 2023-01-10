package org.example.inherit;

import org.example.basic.Dancer;

public class StreetDancer extends Dancer {

    public StreetDancer(String cureName, String myName) {
        super(cureName, myName);
        System.out.println("스트릿댄서 생성됌.");
    }

    @Override
    public void dance() {
        System.out.println("비보잉을 합니다.");
    }
}
