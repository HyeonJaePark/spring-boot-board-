package com.umc.board.user.service;

import com.umc.board.user.model.GetUserRes;
import com.umc.board.user.model.PostUserReq;
import com.umc.board.user.model.PostUserRes;
import com.umc.board.user.model.User;
import com.umc.board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;


    @Transactional(readOnly = true)
    public List<GetUserRes> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(GetUserRes::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public PostUserRes createUser(PostUserReq postUserReq) {
        String pwd;
        try {
            // 암호화
            pwd = bCryptPasswordEncoder.encode(postUserReq.getPassword());
            postUserReq.setPassword(pwd);
        } catch (Exception e) {
            throw new IllegalStateException("암호화 실패");
        }

        try {
            User user = userRepository.save(postUserReq.toEntity());
            return new PostUserRes(user.getId());
        } catch (Exception e) {
            throw new IllegalStateException("실패");
        }
    }
}
