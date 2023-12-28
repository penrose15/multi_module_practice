package org.example.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.example.core.dto.member.MemberDto;
import org.example.domain.member.domain.Member;
import org.example.domain.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public Long save(MemberDto memberDto) {
        Member member = Member.builder()
                .email(memberDto.email())
                .name(memberDto.name())
                .build();
        member = memberRepository.save(member);
        return member.getId();
    }

    public void updateAllMembersUpdated() {
        List<Member> members = memberRepository.findAll();
        members.forEach(Member::updateTime);

        memberRepository.saveAll(members);
    }

    @Transactional(readOnly = true)
    public MemberDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 member"));

        return MemberDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }
}
