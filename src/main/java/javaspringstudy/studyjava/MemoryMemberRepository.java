package javaspringstudy.studyjava;

import javaspringstudy.studyjava.dto.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Repository
public class MemoryMemberRepository  implements MemberRepository {

    private static Map<Long, Member> members = new HashMap<>();

    @Override
    public void save(Member member) {
       members.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        Member member = members.get(id);
        return member;
    }


}
