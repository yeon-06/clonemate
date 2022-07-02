package com.ndex.clonemate.certificate.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ndex.clonemate.certificate.handler.dto.LoginResponseDto;
import com.ndex.clonemate.certificate.model.CustomAuthenticationToken;
import com.ndex.clonemate.global.dto.ApiResult;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        CustomAuthenticationToken customAuthenticationToken = (CustomAuthenticationToken) authentication;
        LoginResponseDto responseDto = new LoginResponseDto(customAuthenticationToken.getId(),
                customAuthenticationToken.getAccount());

        ApiResult<LoginResponseDto> apiResult = ApiResult.<LoginResponseDto>builder()
                .success(true)
                .data(responseDto)
                .build();

        objectMapper.writeValue(response.getWriter(), apiResult);
    }
}
