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
    @GetMapping("/users/{id}")
    public UserResponseDto myPage(@PathVariable Long id) {
        return userService.findByUserId(id);
    }

    @ResponseBody
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }

    @ResponseBody
    @PatchMapping("/users/{id}")
    public void deleteUser(@RequestBody UserUpdateRequestDto userUpdateRequestDto, @PathVariable Long id) {
        userService.update(id, userUpdateRequestDto);
    }
}
