package javaspringstudy.studyjava;

import javaspringstudy.studyjava.dto.Member;
import org.springframework.stereotype.Repository;


@Repository
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP.ordinal()){
            return discountFixAmount;
        } else {
            return 0;
        }

    }
}
