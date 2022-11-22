package com.umc.board.post.service;

import com.umc.board.post.model.Post;
import com.umc.board.post.model.PostReq;
import com.umc.board.post.model.PostRes;
import com.umc.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostRes> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostRes::fromEntity)
                .collect(Collectors.toList());
    }

    public void createPost(PostReq postReq) {
        postRepository.save(postReq.toEntity());
    }

    @Transactional(readOnly = true)
    public PostRes getPost(Long postId) {
        Post post = postRepository.findById(postId).
                orElseThrow(() -> new RuntimeException("존재하지 않는 게시물 ID" + postId));
        return PostRes.fromEntity(post);
    }

    public PostRes updatePost(Long postId, PostReq postReq) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시물 ID" + postId));
        post.updatePost(postReq);
        return PostRes.fromEntity(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public Page<PostRes> findAll(Pageable pageable) {
        return postRepository.findAllByOrderByIdDesc(pageable)
                .map(PostRes::fromEntity);
    }
}
