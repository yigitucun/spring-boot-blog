package com.yigit.blog.business.rules;

import com.yigit.blog.dataAccess.abstracts.ICategoryRepository;
import com.yigit.blog.exceptions.businessException.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private ICategoryRepository categoryRepository;

    public void checkIfCategoryId(int id){
        if (!this.categoryRepository.existsById(id)){
            throw new BusinessException("Böyle bir kategori yok", HttpStatus.BAD_REQUEST);
        }
    }
}
