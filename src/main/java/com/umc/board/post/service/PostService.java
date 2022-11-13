package com.umc.board.post.service;

import com.umc.board.post.model.Post;
import com.umc.board.post.model.PostRes;
import com.umc.board.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<PostRes> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostRes::fromEntity)
                .collect(Collectors.toList());
    }
}
