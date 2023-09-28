package com.yigit.blog.business.rules;

import com.yigit.blog.dataAccess.abstracts.ITagRepository;
import com.yigit.blog.exceptions.businessException.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TagBusinessRules {
    private ITagRepository tagRepository;
    public void checkIfTagId(int id){
        if(!this.tagRepository.existsById(id)){
            throw new BusinessException("Böyle bir " + id + "'li etiket yok.", HttpStatus.NOT_FOUND);
        }
    }
}
