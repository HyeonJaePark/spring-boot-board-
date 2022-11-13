package com.umc.board.user.controller;

import com.umc.board.user.model.GetUserRes;
import com.umc.board.user.model.PostUserReq;
import com.umc.board.user.model.PostUserRes;
import com.umc.board.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    /**
     * 회원가입 API
     */
    @ResponseBody
    @PostMapping("/users/join")
    public ResponseEntity<Void> createUser(@RequestBody PostUserReq postUserReq) {

        // email 에 값이 존재하는지, 빈 값으로 요청하지 않았는지 검사. 빈값이라면 에러 메세지를 보냄.
        if (postUserReq.getEmail() == null) {
            return null;
        }

        // TODO email 정규표현 확인

        // 회원가입 요청 시도
        try {
            PostUserRes user = userService.createUser(postUserReq);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return ResponseEntity.ok().build();
    }

    /**
     * TODO 로그인 API
     */

    /**
     * 회원조회 API
     */
    @GetMapping("/users")
    public ResponseEntity<List<GetUserRes>> LoadUser() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
