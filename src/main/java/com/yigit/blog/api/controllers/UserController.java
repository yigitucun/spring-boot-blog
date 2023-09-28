package com.yigit.blog.api.controllers;

import com.yigit.blog.business.abstracts.UserService;
import com.yigit.blog.dto.requests.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @PostMapping
    private ResponseEntity<?> add(@RequestBody @Valid CreateUserRequest userRequest){
        return new ResponseEntity<>(this.userService.add(userRequest),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable int id){
        Map<String,String> message = new HashMap<>();
        message.put("message","Kullanıcı başarıyla silindi");
        this.userService.deleteById(id);
        return ResponseEntity.ok(message);
    }
}
