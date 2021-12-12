package hello.core.member;

public interface MemberRepository {

    void save(Member mbmer);
    Member findById(Long memberId);

}
