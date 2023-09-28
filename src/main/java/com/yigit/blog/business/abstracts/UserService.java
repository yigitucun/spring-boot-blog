package com.yigit.blog.business.abstracts;

import com.yigit.blog.dto.requests.CreateUserRequest;
import com.yigit.blog.dto.responses.ListUserResponse;

import java.util.List;

public interface UserService {
    List<ListUserResponse> getAll();
    CreateUserRequest add(CreateUserRequest userRequest);
    void deleteById(int id);
}
