package com.ndex.clonemate.user.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String userId;
    private String email;
    private String name;
    private String introText;
    private char emailSearchYn;
    private char randomYn;
}
