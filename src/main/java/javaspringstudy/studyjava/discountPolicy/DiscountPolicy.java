package javaspringstudy.studyjava.discountPolicy;

import javaspringstudy.studyjava.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
