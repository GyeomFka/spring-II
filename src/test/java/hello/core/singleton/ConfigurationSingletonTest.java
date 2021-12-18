package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void new가_두_번_호출_근데_같니() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService → memberRepository : " + memberRepository1);
        System.out.println("orderService → memberRepository : " + memberRepository2);
        System.out.println("memberRepository : " + memberRepository);
        /*
        *   memberService → memberRepository :  hello.core.member.MemoryMemberRepository@ec2cc4
        *   orderService → memberRepository :   hello.core.member.MemoryMemberRepository@ec2cc4
        *   memberRepository :                  hello.core.member.MemoryMemberRepository@ec2cc4
        *   new연산자 3번인데 ? 다 같다 ?
        * */
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
        /*
        * bean.getClass() = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$721f06a6
        * */
    }
}
