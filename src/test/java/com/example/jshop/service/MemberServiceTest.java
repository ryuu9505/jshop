package com.example.jshop.service;

import com.example.jshop.domain.Member;
import com.example.jshop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void join() throws Exception {

        //Given
        Member member = new Member();
        member.setName("kim");

        //When
        Long savedId = memberService.join(member);
        Member foundMember = memberRepository.findById(savedId);

        //Then
        Assertions.assertThat(member).isEqualTo(foundMember);
    }

    @Test
    void validation() throws Exception {

        //Given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //When
        memberService.join(member1);

        // then
        assertThrows(IllegalStateException.class, () -> memberService.join(member1));

    }

}