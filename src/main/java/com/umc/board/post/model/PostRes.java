package com.umc.board.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRes {

    private Long id;
    private String content;

    public static PostRes fromEntity(Post post) {
        return new PostRes(post.getId(), post.getContent());
    }
}
