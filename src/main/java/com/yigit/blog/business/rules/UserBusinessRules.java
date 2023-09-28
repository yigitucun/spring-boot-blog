package com.yigit.blog.business.rules;

import com.yigit.blog.dataAccess.abstracts.IUserRepository;
import com.yigit.blog.exceptions.businessException.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private IUserRepository userRepository;

    public void checkIfUserUsername(String username){
        if(this.userRepository.existsByUsername(username)){
            throw new BusinessException("Kullanıcı adı zaten kayıtlı.", HttpStatus.BAD_REQUEST);
        }
    }
    public void checkIfUserId(int id){
        if (!this.userRepository.existsById(id)){
            throw new BusinessException("Böyle bir kullanıcı yok.",HttpStatus.NOT_FOUND);
        }
    }
}
