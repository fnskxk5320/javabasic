package org.example.inherit;

import org.example.basic.Dancer;

public class IdolDancer extends Dancer {
    private int numberOfFan;

    public IdolDancer(String crueName, String myName) {
        super(crueName, myName);
        this.numberOfFan = 1000;
        System.out.println("아이돌 댄서 생성됌.");
    }

    @Override
    public void dance() {
        wink();
    }
    private void wink() {
        System.out.println("윙크를 세게 날립니다.");
    }
}
