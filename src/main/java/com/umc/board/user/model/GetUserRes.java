package com.umc.board.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetUserRes {

    private Long id;
    private String email;
    private String nickname;

    public static GetUserRes fromEntity(User user) {
        return new GetUserRes(user.getId(), user.getEmail(), user.getNickname());
    }
}
