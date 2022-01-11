package com.ndex.clonemate.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "user_id")
    private String userId;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(name = "intro_text")
    private String introText;

    @Column(nullable = false, name = "delete_yn")
    private char deleteYn;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    @Column(nullable = false, name = "email_search_yn")
    private char emailSearchYn;

    @Column(nullable = false, name = "random_yn")
    private char randomYn;

    @Builder
    public User(Long id, String userId, String name, String email,
                String password, String introText, char deleteYn,
                LocalDateTime deleteDate, char emailSearchYn, char randomYn) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.introText = introText;
        this.deleteYn = deleteYn;
        this.deleteDate = deleteDate;
        this.emailSearchYn = emailSearchYn;
        this.randomYn = randomYn;
    }
}
