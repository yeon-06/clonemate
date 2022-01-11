package com.ndex.clonemate.user.web.dto;

import com.ndex.clonemate.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String userId;
    private String email;
    private String name;
    private String introText;
    private char emailSearchYn;
    private char randomYn;

    @Builder
    public UserUpdateRequestDto(String userId, String email, String name, String introText, char emailSearchYn, char randomYn) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.introText = introText;
        this.emailSearchYn = emailSearchYn;
        this.randomYn = randomYn;
    }
}
