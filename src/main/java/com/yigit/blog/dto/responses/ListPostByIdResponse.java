package com.yigit.blog.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPostByIdResponse {
    private int id;
    private String title;
    private String content;
    @JsonProperty("author")
    private ListUserByPostResponse userByPostResponse;
    @JsonProperty("category")
    private String categoryCategory;
    @JsonProperty("tags")
    private List<ListPostByTagResponse> tags;
}
