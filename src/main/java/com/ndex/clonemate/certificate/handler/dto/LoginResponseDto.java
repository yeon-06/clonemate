package com.ndex.clonemate.certificate.handler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponseDto {

    private Long id;
    private String account;

    public LoginResponseDto(Long id, String account) {
        this.id = id;
        this.account = account;
    }
}
