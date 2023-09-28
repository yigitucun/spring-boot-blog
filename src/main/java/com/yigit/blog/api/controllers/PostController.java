package com.yigit.blog.api.controllers;

import com.yigit.blog.business.abstracts.PostService;
import com.yigit.blog.dto.requests.CreatePostRequest;
import com.yigit.blog.dto.requests.UpdatePostRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.postService.getAll());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable int id){
        Map<String,String> response = new HashMap<>();
        response.put("message","Başarıyla silindi");
        this.postService.deleteById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody UpdatePostRequest postRequest){
        return new ResponseEntity<>(this.postService.update(postRequest),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable int id){
        return new ResponseEntity<>(this.postService.getById(id),HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> add(@RequestBody @Valid CreatePostRequest postRequest){
        return new ResponseEntity<>(this.postService.add(postRequest), HttpStatus.CREATED);
    }
}
