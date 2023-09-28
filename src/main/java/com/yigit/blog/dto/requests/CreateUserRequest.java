package com.yigit.blog.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserRequest {
    @NotBlank(message = "Bu alan zorunludur.")
    @Length(min = 3,message = "Minimum 3 karakter olmalıdır.")
    private String username;
    @NotBlank(message = "Bu alan zorunludur.")
    @Length(min = 3,message = "Minimum 3 karakter olmalıdır.")
    private String name;
}
