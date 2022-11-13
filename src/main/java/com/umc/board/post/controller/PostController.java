package com.umc.board.post.controller;

import com.umc.board.post.model.PostReq;
import com.umc.board.post.model.PostRes;
import com.umc.board.post.service.PostService;
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
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/all")
    public ResponseEntity<List<PostRes>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("posts/new")
    public ResponseEntity<Void> createNewPost(@RequestBody PostReq postReq) {
        postService.createPost(postReq);
        return ResponseEntity.ok().build();
    }
}
