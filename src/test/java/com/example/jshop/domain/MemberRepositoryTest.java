package com.example.jshop.domain;

import com.example.jshop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    //@Rollback(false)
    public void testMember() {

        Member member = new Member();
        member.setName("kim");
        Long savedId = memberRepository.save(member);
        Member foundMember = memberRepository.findById(savedId);

        Assertions.assertThat(foundMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(foundMember.getName()).isEqualTo(member.getName());
        Assertions.assertThat(foundMember).isEqualTo(member);
    }

}