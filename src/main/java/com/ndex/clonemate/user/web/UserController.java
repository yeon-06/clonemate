package com.ndex.clonemate.user.web;

import com.ndex.clonemate.user.service.UserService;
import com.ndex.clonemate.user.web.dto.UserResponseDto;
import com.ndex.clonemate.user.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @ResponseBody
    @GetMapping("/users/{userId}")
    public UserResponseDto myPage(@PathVariable String userId) {
        return userService.findByUserId(userId);
    }

    @ResponseBody
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.delete(userId);
    }

    @ResponseBody
    @PatchMapping("/users/{userId}")
    public void deleteUser(@RequestBody UserUpdateRequestDto userUpdateRequestDto, @PathVariable String userId) {
        userService.update(userId, userUpdateRequestDto);
    }
}
