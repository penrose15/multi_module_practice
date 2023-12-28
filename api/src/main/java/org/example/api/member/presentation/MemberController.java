package org.example.api.member.presentation;

import lombok.RequiredArgsConstructor;
import org.example.api.member.application.MemberFacade;
import org.example.core.dto.member.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberFacade memberFacade;

    @PostMapping
    public ResponseEntity<Void> saveMember(@RequestBody MemberDto request) {
        memberFacade.saveMember(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{member-id}")
    public ResponseEntity<MemberDto> findMemberById(@PathVariable("member-id")Long memberId) {
        MemberDto response = memberFacade.findMemberById(memberId);
        return ResponseEntity.ok(response);
    }
}
