package org.example.basic;

import java.util.Enumeration;

public class Dancer {
    private final String crueName;
    private final String myName;
    private DanceLevel level = DanceLevel.PRO;
    private boolean stretch;
    private boolean flexible;

    public Dancer() {
        this("크루 없음", "이름 없음");
    }

    public Dancer(String cureName, String myName) {
        this.crueName = cureName;
        this.myName = myName;
        System.out.println("그냥 댄서 생성됌.");
    }

    private void stretch() {
        System.out.println(myName + "님이 스트레칭 합니다.");
        this.stretch = true;
    }

    private void makeFlexible() {
        if(!stretch) {
            System.out.println(myName + "님이 스트레칭을 안해서 죽엇습니다.");
            return;
        }
        System.out.println(myName + "님이 유연성 운동을 합니다.");
        this.flexible = true;
    }

    public void dance() {
        stretch();
        makeFlexible();
        if(!flexible) {
            System.out.println(myName + "님이 유연성 운동을 안해서 죽었습니다.");
            return;
        }
        System.out.println((myName + "님이 춤을 춥니다."));
    }

    public String getCrueName() {
        return crueName;
    }

    public String getMyName() {
        return myName;
    }
}
