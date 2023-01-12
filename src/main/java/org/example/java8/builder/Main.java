package org.example.java8.builder;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // 회원 정보 생성
        /*
        Member m = new Member();
        m.setAccount("abc1234");
        m.setPassword("1234");
        m.setAge(23);
        */
//        Member m = new Member("abc1234", "1234");
//        m.setAge(23);
        Member.builder()
                .account("abc1234")
                .password("1234")
                .regDate(LocalDateTime.now())
                .build();

        Board.builder()
                .content("안녕하세요")
                .writer("김찬혁")
                .id(700L)
                .title("인사")
                .build();

    }
}
