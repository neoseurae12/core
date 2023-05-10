package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;  // 단순히 이렇게 고치기만 하면 NullPointException 발생 (구현체가 없으니까!) => 생성자 必

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);    // 회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 정책에 회원 그냥 넘기기 (SRP ; 단일 책임 원칙)

        return new Order(memberId, itemName, itemPrice, discountPrice); //1. 주문 생성' & '4. 주문 결과 반환
    }
}
