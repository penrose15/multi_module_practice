package org.example.core.dto.member;

import lombok.Builder;

import java.util.Objects;

public record MemberDto(String name, String email) {
    @Builder
    public MemberDto(String name, String email) {
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
    }
}
