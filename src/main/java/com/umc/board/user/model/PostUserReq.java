package com.umc.board.user.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostUserReq {

    private String email;
    private String password;
    private String nickname;

    public User toEntity() {
        return new User(this.email, this.password, this.nickname);
    }
}
