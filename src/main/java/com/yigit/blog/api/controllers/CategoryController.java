package com.yigit.blog.api.controllers;

import com.yigit.blog.business.abstracts.CategoryService;
import com.yigit.blog.dto.requests.CreateCategoryRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.categoryService.getAll());
    }

    @PostMapping
    private ResponseEntity<?> add(@RequestBody @Valid CreateCategoryRequest categoryRequest){
        return new ResponseEntity<>(this.categoryService.add(categoryRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteById(@PathVariable int id){
        Map<String,String> response = new HashMap<>();
        response.put("message","Başarıyla silindi");
        this.categoryService.deleteById(id);
        return ResponseEntity.ok(response);
    }


}
