package org.example;

import org.example.basic.Dancer;
import org.example.inherit.IdolDancer;
import org.example.inherit.StreetDancer;
import org.example.poly.PerformanceTeam;

public class Main {
    public static void main(String[] args) {
      /*  Dancer dancer = new Dancer("방탄소년단", "김찬혁");

        dancer.dance();

        IdolDancer idolDancer = new IdolDancer("엑소", "김찬혁");
        idolDancer.dance();

        StreetDancer streetDancer = new StreetDancer("스보파", "김찬혁");
        streetDancer.dance(); */
        IdolDancer idolDancer = new IdolDancer(" 언니즈", "아이네");
        IdolDancer idolDancer2 = new IdolDancer(" 언니즈", "징버거");
        IdolDancer idolDancer3 = new IdolDancer(" 언니즈", "릴파");
        StreetDancer streetDancer = new StreetDancer("동생즈", "주르르");
        StreetDancer streetDancer2 = new StreetDancer("동생즈", "고세구");
        StreetDancer streetDancer3 = new StreetDancer("동생즈", "비챤");
        PerformanceTeam team = new PerformanceTeam();

        team.joinDancer(idolDancer);
        team.joinDancer(idolDancer2);
        team.joinDancer(idolDancer3);
        team.joinDancer(streetDancer);
        team.joinDancer(streetDancer2);
        team.joinDancer(streetDancer3);
    }
}