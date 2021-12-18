package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void 스프링_없는_순수한_DI컨테이너() {
        AppConfig appConfig = new AppConfig();
        //고객의 조회1 : 호출할 떄 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //고객의 조회2 : 호출할 떄 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        /*
        * memberService1 = hello.core.member.MemberServiceImpl@65d09a04
        * memberService2 = hello.core.member.MemberServiceImpl@33c911a1
        * */
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    void 싱글톤_패턴을_적용한_객체_사용() {
//        new SingletonService(); -> private access
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        assertThat(instance1).isSameAs(instance2);
        //same - == 비교
        //equal - equals 비교
    }

}
