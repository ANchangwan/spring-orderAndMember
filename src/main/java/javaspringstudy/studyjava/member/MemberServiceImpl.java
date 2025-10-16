package javaspringstudy.studyjava.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@Service

@Component
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        System.out.println("memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

}
