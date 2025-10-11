package javaspringstudy.studyjava;

import javaspringstudy.MemberService;
import javaspringstudy.studyjava.dto.Member;
import javaspringstudy.studyjava.dto.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyJavaApplicationTests {
    MemberService ms = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());


    @Test
    void join(){
        Member member = new Member(1L, "changwan", Grade.VIP.ordinal());
        ms.join(member);
        Member findMember = ms.findMember(1L);

        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void createOrder(){
        Member member = new Member(1L, "changwan", Grade.VIP.ordinal());
       ms.join(member);
        Order itemA = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }

}
