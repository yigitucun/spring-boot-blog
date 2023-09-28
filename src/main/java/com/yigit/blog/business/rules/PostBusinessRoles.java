package com.yigit.blog.business.rules;

import com.yigit.blog.dataAccess.abstracts.IPostRepository;
import com.yigit.blog.dataAccess.abstracts.IUserRepository;
import com.yigit.blog.exceptions.businessException.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostBusinessRoles {

    private IPostRepository postRepository;
    public void checkIfPostId(int id){
        if(!this.postRepository.existsById(id)){
            throw new BusinessException("Böyle bir post yok.", HttpStatus.NOT_FOUND);
        }
    }
}
