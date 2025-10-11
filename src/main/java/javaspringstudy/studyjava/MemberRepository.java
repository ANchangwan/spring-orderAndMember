package javaspringstudy.studyjava;

import javaspringstudy.studyjava.dto.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
}
