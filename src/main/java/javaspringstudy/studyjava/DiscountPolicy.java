package javaspringstudy.studyjava;

import javaspringstudy.studyjava.dto.Member;
import javaspringstudy.studyjava.dto.Order;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
