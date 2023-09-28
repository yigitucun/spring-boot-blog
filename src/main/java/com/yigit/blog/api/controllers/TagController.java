package com.yigit.blog.api.controllers;

import com.yigit.blog.business.abstracts.TagService;
import com.yigit.blog.dto.requests.CreateTagRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.tagService.getAll());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable int id){
        Map<String,String> message = new HashMap<>();
        this.tagService.deleteById(id);
        message.put("message","Başarıyla silindi.");
        return ResponseEntity.ok(message);
    }

    @PostMapping
    private ResponseEntity<?> add(@RequestBody @Valid CreateTagRequest tagRequest){
        return new ResponseEntity<>(this.tagService.add(tagRequest), HttpStatus.CREATED);
    }
}
