package com.rameshkittur.Spring.Boot.Features.controllers;

import com.rameshkittur.Spring.Boot.Features.dto.PostDto;
import com.rameshkittur.Spring.Boot.Features.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostService postService;

    @GetMapping
    public List<PostDto>getAllPosts(){
       return postService.getAllPosts();
    }

    @PostMapping
    public PostDto addNewPost(@RequestBody PostDto inputPost){
        return postService.savePost(inputPost);
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable(name = "postId")Long id){
        return postService.getPostById(id);
    }

    @PutMapping("/{postId}")
    public PostDto updatePost(@RequestBody PostDto post,@PathVariable Long postId){
        return postService.updatePost(post,postId);
    }
}
