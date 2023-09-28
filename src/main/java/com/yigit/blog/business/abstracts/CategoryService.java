package com.yigit.blog.business.abstracts;

import com.yigit.blog.dto.requests.CreateCategoryRequest;
import com.yigit.blog.dto.responses.ListCategoryResponse;

import java.util.List;

public interface CategoryService {
    CreateCategoryRequest add(CreateCategoryRequest categoryRequest);
    void deleteById(int id);

    List<ListCategoryResponse> getAll();


}
