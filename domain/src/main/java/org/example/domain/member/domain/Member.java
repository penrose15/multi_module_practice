package org.example.domain.member.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    private LocalDateTime created;
    private LocalDateTime updated;

    @Builder
    public Member(String name, String email) {
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
        this.created = LocalDateTime.now();
    }

    public void updateTime() {
        this.updated = LocalDateTime.now();
    }
}
