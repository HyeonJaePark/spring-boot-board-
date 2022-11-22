package com.umc.board.post.controller;

import com.umc.board.post.model.PostReq;
import com.umc.board.post.model.PostRes;
import com.umc.board.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("posts/all")
    public ResponseEntity<List<PostRes>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("posts/{postId}")
    public ResponseEntity<PostRes> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @GetMapping("posts/list")
    public ResponseEntity<List<PostRes>> getPostByPage(Pageable pageable) {
        return ResponseEntity.ok(postService.findAll(pageable).getContent());
    }

    @PostMapping("posts/new")
    public ResponseEntity<Void> createNewPost(@RequestBody PostReq postReq) {
        postService.createPost(postReq);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("posts/{postId}")
    public ResponseEntity<PostRes> updatePost(@PathVariable Long postId, @RequestBody PostReq postReq) {
        return ResponseEntity.ok(postService.updatePost(postId, postReq));
    }

    @DeleteMapping("posts/{postId}")
    public ResponseEntity<PostRes> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
