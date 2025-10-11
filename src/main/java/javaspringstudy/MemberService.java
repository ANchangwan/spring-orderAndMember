package javaspringstudy;

import javaspringstudy.studyjava.dto.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long id);
}
