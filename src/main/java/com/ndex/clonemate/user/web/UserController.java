package com.ndex.clonemate.user.web;

import com.ndex.clonemate.user.service.UserService;
import com.ndex.clonemate.user.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @ResponseBody
    @GetMapping("/users/{userId}")
    public UserResponseDto myPage(@PathVariable String userId) {
        return userService.findByUserId(userId);
    }

}
