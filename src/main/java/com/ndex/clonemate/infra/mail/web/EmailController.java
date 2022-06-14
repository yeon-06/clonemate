package com.ndex.clonemate.infra.mail.web;

import com.ndex.clonemate.infra.mail.service.EmailService;
import com.ndex.clonemate.infra.mail.web.dto.UserPasswordRequestDto;
import com.ndex.clonemate.global.dto.ApiResult;
import com.ndex.clonemate.global.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @GetMapping("/users/email/certify/{id}")
    public ApiResult<String> sendCertifyMail(@PathVariable long id) {
        String token = emailService.sendCertifyMail(id);
        return ApiUtils.createSuccessApi(token);
    }

    @GetMapping("/users/email/{id}")
    public ApiResult<Void> checkCertifyMail(@PathVariable Long id, @RequestParam String token) {
        emailService.checkCertifyMail(id, token);
        return ApiUtils.createSuccessEmptyApi();
    }

    @GetMapping("/users/email/reset/{id}")
    public ApiResult<String> sendResetPasswordMail(@PathVariable long id) {
        String token = emailService.sendResetPasswordMail(id);
        return ApiUtils.createSuccessApi(token);
    }

    @PutMapping("/users/email/password")
    public ApiResult<Void> changePassword(@RequestBody UserPasswordRequestDto request) {
        emailService.changePassword(request);
        return ApiUtils.createSuccessEmptyApi();
    }
}
