package com.yigit.blog.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUserByPostResponse {
    private int id;
    private String username;
    private String name;
}
