package com.yigit.blog.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListUserResponse {
    private int id;
    private String username;
    private String name;
}
