package com.example.jshop.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {

        Member member = new Member();
        member.setUsername("kim");
        Long savedId = memberRepository.save(member);
        Member foundMember = memberRepository.find(savedId);

        Assertions.assertThat(foundMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(foundMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(foundMember).isEqualTo(member);
    }

}