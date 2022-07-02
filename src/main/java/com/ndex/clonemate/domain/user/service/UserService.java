package com.ndex.clonemate.domain.user.service;

import com.ndex.clonemate.domain.user.repository.User;
import com.ndex.clonemate.domain.user.repository.UserRepository;
import com.ndex.clonemate.domain.user.web.dto.UserRegisterRequestDto;
import com.ndex.clonemate.domain.user.web.dto.UserResponseDto;
import com.ndex.clonemate.domain.user.web.dto.UserUpdateRequestDto;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;

    @Transactional
    public Long register(UserRegisterRequestDto requestDto) {
        validateDuplicate(requestDto);
        User entity = requestDto.toEntity();
        entity.encodePassword(encoder);
        return userRepository.save(entity).getId();
    }

    private void validateDuplicate(UserRegisterRequestDto requestDto) {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalStateException("[ERROR] 중복된 메일이 존재합니다.");
        }

        if (userRepository.existsByAccount(requestDto.getUserId())) {
            throw new IllegalStateException("[ERROR] 중복된 아이디가 존재합니다.");
        }
    }

    public UserResponseDto findByUserId(long id) {
        User entity = findUser(id);
        return new UserResponseDto(entity);
    }

    @Transactional
    public void delete(long id) {
        User entity = findUser(id);
        entity.changeDeleteFlag();
    }

    @Transactional
    public void update(long id, UserUpdateRequestDto request) {
        User entity = findUser(id);
        entity.update(request.getUserId(), request.getEmail(), request.getName(),
                request.getIntroText(), request.getEmailSearchYn(), request.getRandomYn());
    }

    private User findUser(long id) {
        return userRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 사용자가 없습니다."));
    }

    public boolean haveUserByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean haveUserByAccount(String account) {
        return userRepository.existsByAccount(account);
    }

    public List<User> findRandomUsers() {
        return userRepository.findByRandom('Y', 'N', 'Y');
    }
}
