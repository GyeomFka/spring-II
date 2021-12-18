package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //추상화에도 의존하고, 구체화에도 의존한다. -> DIP위반

    /*
    * app config 생성
    * */
    private final MemberRepository memberRepository; // → 추상화에만 의존한다 → DIP를 지킨다.

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //-> 다형성에 의해 구현체의 save가 실행이 된다.
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //for singleton test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
