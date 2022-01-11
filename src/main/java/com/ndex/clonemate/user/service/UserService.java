package com.ndex.clonemate.user.service;

import com.ndex.clonemate.user.domain.User;
import com.ndex.clonemate.user.domain.UserRepository;
import com.ndex.clonemate.user.web.dto.UserResponseDto;
import com.ndex.clonemate.user.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final static char FLAG_YES = 'Y';
    private final static char FLAG_NO = 'N';
    private final static String ERROR_NO_USER = "[ERROR] 해당 사용자가 없습니다.";
    private final UserRepository userRepository;

    public UserResponseDto findByUserId(Long id) {
        User entity = userRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NO_USER));
        return new UserResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        User entity = userRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NO_USER));
        entity.changeDeleteFlag();
    }

    @Transactional
    public void update(Long id, UserUpdateRequestDto request) {
        User entity = userRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_NO_USER));

        entity.update(request.getUserId(), request.getEmail(), request.getName(),
                request.getIntroText(), request.getEmailSearchYn(), request.getRandomYn());
    }

}
