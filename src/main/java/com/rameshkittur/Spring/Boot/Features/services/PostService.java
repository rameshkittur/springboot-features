package com.rameshkittur.Spring.Boot.Features.services;

import com.rameshkittur.Spring.Boot.Features.dto.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto>getAllPosts();

    PostDto savePost(PostDto inputPost);

    PostDto getPostById(Long id);
}
