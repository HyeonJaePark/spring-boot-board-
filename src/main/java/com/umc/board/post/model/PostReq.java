package com.umc.board.post.model;

import lombok.Getter;

@Getter
public class PostReq {

    private String content;

    public Post toEntity() {
        return new Post(this.content);
    }
}
