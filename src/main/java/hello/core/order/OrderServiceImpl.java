package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //final -> 키워드로 생성자를 만들어준다.
public class OrderServiceImpl implements OrderService{

//  private final MemberRepository memberRepository = new MemoryMemberRepository();
//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//  private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //fix → rate 고치는 것 자체가 DIP 위반

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired //생성자 하나일 때, 생략가능
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);//할인은 나는 몰라 니가 알아서 해줘
        // SRP
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //for singleton test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
