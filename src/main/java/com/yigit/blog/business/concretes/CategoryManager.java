package com.yigit.blog.business.concretes;

import com.yigit.blog.business.abstracts.CategoryService;
import com.yigit.blog.business.rules.CategoryBusinessRules;
import com.yigit.blog.core.utils.modelMapper.ModelMapperService;
import com.yigit.blog.dataAccess.abstracts.ICategoryRepository;
import com.yigit.blog.dto.requests.CreateCategoryRequest;
import com.yigit.blog.dto.responses.ListCategoryResponse;
import com.yigit.blog.entities.concretes.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private ICategoryRepository categoryRepository;
    private ModelMapperService mapperService;
    private CategoryBusinessRules categoryBusinessRules;
    @Override
    public CreateCategoryRequest add(CreateCategoryRequest categoryRequest) {
        Category category = this.mapperService.forRequest().map(categoryRequest, Category.class);
        this.categoryRepository.save(category);
        return categoryRequest;
    }

    @Override
    public void deleteById(int id) {
        this.categoryBusinessRules.checkIfCategoryId(id);
        this.categoryRepository.deleteById(id);
    }

    @Override
    public List<ListCategoryResponse> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        List<ListCategoryResponse> responses = categories.stream().map(category -> this.mapperService.forResponse()
                .map(category, ListCategoryResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
}
