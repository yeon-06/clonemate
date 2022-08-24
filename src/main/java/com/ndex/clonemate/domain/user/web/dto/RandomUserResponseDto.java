package com.ndex.clonemate.domain.user.web.dto;

import com.ndex.clonemate.domain.user.repository.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RandomUserResponseDto {

    private Long id;
    private String userId;
    private String name;
    private String email;
    private String introText;

    @Builder
    public RandomUserResponseDto(User user) {
        this.id = user.getId();
        this.userId = user.getAccount();
        this.name = user.getName();
        this.email = user.getEmail();
        this.introText = user.getIntroText();
    }
}
