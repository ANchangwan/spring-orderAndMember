package javaspringstudy.studyjava;

import javaspringstudy.studyjava.member.MemberService;
import javaspringstudy.studyjava.discountPolicy.DiscountPolicy;
import javaspringstudy.studyjava.discountPolicy.FixDiscountPolicy;
import javaspringstudy.studyjava.member.MemberRepository;
import javaspringstudy.studyjava.member.MemberServiceImpl;
import javaspringstudy.studyjava.member.MemoryMemberRepository;
import javaspringstudy.studyjava.order.OrderService;
import javaspringstudy.studyjava.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
