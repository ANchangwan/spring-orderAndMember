package javaspringstudy.studyjava;

import javaspringstudy.studyjava.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SpringContainerTest {

     AnnotationConfigApplicationContext ac =
             new AnnotationConfigApplicationContext(AppConfig.class);


     @Test
    @DisplayName("모든 빈 출력")
    public void showAllBeans(){
         String[] beanDefinitionNames = ac.getBeanDefinitionNames();
         for (String beanDefinitionName : beanDefinitionNames) {
             Object bean = ac.getBean(beanDefinitionName);
             System.out.println("bean = " + beanDefinitionName + ", obj = " + bean);
         }
     }

     @Test
    @DisplayName("싱글톤 테스트")
    void springContainerTest(){
         MemberService memberService1 = ac.getBean("memberService", MemberService.class);
         MemberService memberService2 = ac.getBean("memberService",
                 MemberService.class);

         System.out.println("memberService1 = " + memberService1);
         System.out.println("memberService2 = " + memberService2);
         //memberService1 == memberService2
         assertThat(memberService1).isSameAs(memberService2);
     }
}
