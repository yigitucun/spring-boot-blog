package com.yigit.blog.business.abstracts;

import com.yigit.blog.dto.requests.CreatePostRequest;
import com.yigit.blog.dto.requests.UpdatePostRequest;
import com.yigit.blog.dto.responses.ListPostByIdResponse;
import com.yigit.blog.dto.responses.ListPostResponse;

import java.util.List;

public interface PostService {
    CreatePostRequest add(CreatePostRequest postRequest);
    List<ListPostResponse> getAll();
    void deleteById(int id);
    ListPostByIdResponse getById(int id);
    UpdatePostRequest update(UpdatePostRequest postResponse);

}
