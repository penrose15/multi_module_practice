package org.example.api.member.application;

import lombok.RequiredArgsConstructor;
import org.example.core.dto.member.MemberDto;
import org.example.domain.member.service.MemberService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;

    public void saveMember(MemberDto memberDto) {
        memberService.save(memberDto);
    }

    public MemberDto findMemberById(Long memberId) {
        return memberService.findById(memberId);
    }


}
