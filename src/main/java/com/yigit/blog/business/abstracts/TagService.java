package com.yigit.blog.business.abstracts;

import com.yigit.blog.dto.requests.CreateTagRequest;
import com.yigit.blog.dto.responses.ListTagResponse;

import java.util.List;

public interface TagService {
    CreateTagRequest add(CreateTagRequest tagRequest);
    List<ListTagResponse> getAll();
    void deleteById(int id);
}
