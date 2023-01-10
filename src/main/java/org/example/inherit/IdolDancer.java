package org.example.inherit;

import org.example.abs.Rapper;
import org.example.abs.Singer;
import org.example.basic.Dancer;

public class IdolDancer extends Dancer implements Singer, Rapper {
    private int numberOfFan;

    @Override
    public void sing() {
        System.out.println("노래를 부릅니다.");
    }

    @Override
    public void rap() {
        System.out.println("랩을 합니다.");
    }

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
        System.out.println("윙크를 세게 날리며 춤 춥니다.");
    }

}
