package org.example.batch.application;

import lombok.RequiredArgsConstructor;
import org.example.domain.member.service.MemberService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatchFacade {
    private final MemberService memberService;

    public void updateAllMembers() {
        memberService.updateAllMembersUpdated();
    }
}
