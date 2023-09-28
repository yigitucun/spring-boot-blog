package com.yigit.blog.dto.requests;

import com.yigit.blog.entities.concretes.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostByTagRequest {
    private int tagId;
}
