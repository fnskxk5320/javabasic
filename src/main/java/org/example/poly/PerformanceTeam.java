package org.example.poly;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTeam {
    private List<Object> dancers = new ArrayList<>();

    public void joinDancer(Dancer dancer) {
        dancers.add(dancer);
        System.out.println(dancer.getMyName() + "님이 팀에 가입하였습니다.");
        System.out.println("현재 팀원 수 : " + dancers.size());
    }

    public void groupDance() {
        for (Object dancer : dancers) {
        }
    }
}
