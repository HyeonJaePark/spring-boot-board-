package com.umc.board.post.controller;

import com.umc.board.post.model.PostRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    @GetMapping("/posts/all")
    public ResponseEntity<List<PostRes>> getAllPosts() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("posts/new")
    public ResponseEntity<Void> createNewPost() {
        ;
    }
}
