package com.ndex.clonemate.user.service;

import com.ndex.clonemate.user.domain.User;
import com.ndex.clonemate.user.domain.UserRepository;
import com.ndex.clonemate.user.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final static char FLAG_YES = 'Y';
    private final static char FLAG_NO = 'N';
    private final UserRepository userRepository;

    public UserResponseDto findByUserId(String userId) {
        User entity = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 사용자가 없습니다."));
        return new UserResponseDto(entity);
    }

}
