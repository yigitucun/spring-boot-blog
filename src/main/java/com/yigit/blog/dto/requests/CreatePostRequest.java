package com.yigit.blog.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
    private String title;
    private String content;
    private int userId;
    private int categoryId;
    private List<CreatePostByTagRequest> tags;
}
