package javaspringstudy.studyjava;

import javaspringstudy.studyjava.dto.Member;
import org.springframework.stereotype.Repository;


//@Repository
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP.ordinal()) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
