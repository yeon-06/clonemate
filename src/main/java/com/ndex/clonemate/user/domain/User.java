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
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(name = "introText")
    private String introText;

    @Column(nullable = false, name = "deleteYn")
    private char deleteYn;

    @Column(name = "deleteDate")
    private LocalDateTime deleteDate;

    @Column(nullable = false, name = "emailSearchYn")
    private char emailSearchYn;

    @Column(nullable = false, name = "randomYn")
    private char randomYn;

    @Builder
    public User(String id, String name, String email,
                String password, String introText, char deleteYn,
                LocalDateTime deleteDate, char emailSearchYn, char randomYn) {
        this.id = id;
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
