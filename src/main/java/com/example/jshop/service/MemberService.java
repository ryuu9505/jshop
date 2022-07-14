package com.example.jshop.service;

import com.example.jshop.domain.Member;
import com.example.jshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    public final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {

        validationDuplicatedMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validationDuplicatedMember(Member member) {
        List<Member> foundMembers = memberRepository.findByName(member.getName());
        if (!foundMembers.isEmpty()) {
            throw new IllegalStateException("It had already signed up.");
        }
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
