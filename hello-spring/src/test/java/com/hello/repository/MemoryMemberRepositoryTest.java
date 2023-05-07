package com.hello.repository;

import com.hello.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void saveTest(){
        Member member = new Member();
        member.setName("김스프링");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(member,result);
    }

    @Test
    public void findbyNameTest(){
        Member member1 = new Member();
        member1.setName("김자바");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("김jpa");
        repository.save(member2);

        Member result = repository.findByName("김자바").get();

        assertTrue(result.getName().equals("김자바"));
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("java");
        repository.save(member2);

        List<Member> all = repository.findAll();

        assertTrue(all.size()==2);
    }
}