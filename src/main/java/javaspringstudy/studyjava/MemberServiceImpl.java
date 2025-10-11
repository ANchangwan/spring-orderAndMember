package javaspringstudy.studyjava;

import javaspringstudy.MemberService;
import javaspringstudy.studyjava.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

}
