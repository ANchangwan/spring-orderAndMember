package javaspringstudy.studyjava;

import javaspringstudy.studyjava.member.MemberService;
import javaspringstudy.studyjava.discountPolicy.FixDiscountPolicy;
import javaspringstudy.studyjava.member.Grade;
import javaspringstudy.studyjava.member.Member;
import javaspringstudy.studyjava.order.Order;
import javaspringstudy.studyjava.member.MemberServiceImpl;
import javaspringstudy.studyjava.member.MemoryMemberRepository;
import javaspringstudy.studyjava.order.OrderService;
import javaspringstudy.studyjava.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyJavaApplicationTests {
    MemberService ms = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());


    @Test
    void join(){
        Member member = new Member(1L, "changwan", Grade.VIP);
        ms.join(member);
        Member findMember = ms.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void createOrder(){
        Member member = new Member(1L, "changwan", Grade.VIP);
       ms.join(member);
        Order itemA = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }

}
