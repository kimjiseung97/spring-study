package com.hello.service;

import com.hello.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void joinTest(){
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long join = memberService.join(member);
        //then
        Member member1 = memberService.findOne(join).get();
        assertTrue(member.getName().equals(member1.getName()));
    }

    @Test
    //중복회원 테스트
    void findMembersTest(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("sprign");
        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()-> memberService.join(member2));
//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalAccessError e){
//            assert(e.getMessage().equals("이미 존재하는 회원입니다."));
//        }

        //then

    }

    @Test
    void findOneTest(){

    }
}