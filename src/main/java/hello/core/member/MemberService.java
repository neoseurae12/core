package hello.core.member;

public interface MemberService {

    // 2가지 기능 ; ⓐ 회원가입, ⓑ 회원조회

    // ⓐ 회원가입
    void join(Member member);

    // ⓑ 회원조회
    Member findMember(Long memberId);
}
