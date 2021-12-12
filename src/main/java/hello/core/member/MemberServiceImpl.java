package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //추상화에도 의존하고, 구체화에도 의존한다. -> DIP위반

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //-> 다형성에 의해 구현체의 save가 실행이 된다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
