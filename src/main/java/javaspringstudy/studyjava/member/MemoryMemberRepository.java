package javaspringstudy.studyjava.member;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class MemoryMemberRepository  implements MemberRepository {

    private static Map<Long, Member> members = new HashMap<>();

    @Override
    public void save(Member member) {
       members.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return members.get(id);
    }


}
