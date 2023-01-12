package org.example.java8.builder;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter @Setter @ToString
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode

public class Member {
    private final String account; // 필수
    private final String password;  // 필수
    private String email;
    private LocalDateTime regDate;
    private int age;
    private boolean emailSend;

    public Member(String account, String password) {
        this.account = account;
        this.password = password;
    }
    public static MemberBuilder builder() {
        return new MemberBuilder();
    }

    // 빌더 패턴 구현
    public static class MemberBuilder {
        private String account;
        private String password;
        private String email;
        private LocalDateTime regDate;
        private int age;
        private boolean emailSend;

        // 내부 기본 생성자를 private로

        private MemberBuilder() {}

        // 빌더 메서드들을 선언

        public MemberBuilder account(String account) {
            this.account = account;
            return this;
        }

        public MemberBuilder password(String password) {
            this.password = password;
            return this;
        }

        public MemberBuilder email(String email) {
            this.email = email;
            return this;
        }

        public MemberBuilder regDate(LocalDateTime regDate) {
            this.regDate = regDate;
            return this;
        }

        public MemberBuilder age(int age) {
            this.age = age;
            return this;
        }

        public MemberBuilder emailSend(boolean emailSend) {
            this.emailSend = emailSend;
            return this;
        }

        public Member build() {
            Member member = new Member(account, password);
            member.setAge(age);
            member.setEmail(email);
            member.setRegDate(regDate);
            member.setEmailSend(emailSend);
            return member;
        }

    }
}
