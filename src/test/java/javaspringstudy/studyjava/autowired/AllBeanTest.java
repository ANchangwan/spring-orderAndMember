package javaspringstudy.studyjava.autowired;

import javaspringstudy.studyjava.AutoAppConfig;
import javaspringstudy.studyjava.discountPolicy.DiscountPolicy;
import javaspringstudy.studyjava.member.Grade;
import javaspringstudy.studyjava.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AllBeanTest {
    @Test
    @DisplayName("모든 빈 조회")
    void findAllBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member userA = new Member(1L, "userA", Grade.VIP);
        int discountPolicy = discountService.discount(userA, 1000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPolicy).isEqualTo(1000);
    }
    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> polices;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> polices) {
            this.policyMap = policyMap;
            this.polices = polices;
            System.out.println("policyMap: " + policyMap);
            System.out.println("polices: " + polices);

        }

        public int discount(Member member, int price, String discounCode) {
            DiscountPolicy discountPolicy = policyMap.get(discounCode);
            System.out.println("discountPolicy: " + discounCode);
            System.out.println("discountPolicy: " + discountPolicy);

            return discountPolicy.discount(member, price);
        }
    }
}
