package com.yigit.blog.business.concretes;

import com.yigit.blog.business.abstracts.PostService;
import com.yigit.blog.business.rules.CategoryBusinessRules;
import com.yigit.blog.business.rules.PostBusinessRoles;
import com.yigit.blog.business.rules.TagBusinessRules;
import com.yigit.blog.business.rules.UserBusinessRules;
import com.yigit.blog.core.utils.modelMapper.ModelMapperService;
import com.yigit.blog.dataAccess.abstracts.IPostRepository;
import com.yigit.blog.dto.requests.CreatePostByTagRequest;
import com.yigit.blog.dto.requests.CreatePostRequest;
import com.yigit.blog.dto.requests.UpdatePostRequest;
import com.yigit.blog.dto.responses.ListPostByIdResponse;
import com.yigit.blog.dto.responses.ListPostResponse;
import com.yigit.blog.entities.concretes.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

    private IPostRepository postRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules userBusinessRules;
    private PostBusinessRoles postBusinessRoles;
    private CategoryBusinessRules categoryBusinessRules;
    private TagBusinessRules tagBusinessRules;

    @Override
    public CreatePostRequest add(CreatePostRequest postRequest) {
        this.userBusinessRules.checkIfUserId(postRequest.getUserId());
        this.categoryBusinessRules.checkIfCategoryId(postRequest.getCategoryId());
        postRequest.getTags().stream().map(
                CreatePostByTagRequest::getTagId)
                .forEach(tagId -> this.tagBusinessRules.checkIfTagId(tagId)
                );

        Post post = this.mapperService.forRequest().map(postRequest,Post.class);
        this.postRepository.save(post);
        return postRequest;
    }

    @Override
    public UpdatePostRequest update(UpdatePostRequest postResponse) {
        this.postBusinessRoles.checkIfPostId(postResponse.getId());
        Post post = this.mapperService.forRequest().map(postResponse,Post.class);
        this.postRepository.save(post);
        return postResponse;
    }

    @Override
    public ListPostByIdResponse getById(int id) {
        this.postBusinessRoles.checkIfPostId(id);
        Post post = this.postRepository.findById(id).orElseThrow();
        ListPostByIdResponse response = this.mapperService.forResponse().map(post,ListPostByIdResponse.class);
        return response;
    }

    @Override
    public void deleteById(int id) {
        this.postBusinessRoles.checkIfPostId(id);
        this.postRepository.deleteById(id);
    }

    @Override
    public List<ListPostResponse> getAll() {
        List<Post> posts = this.postRepository.findAll();
        List<ListPostResponse> responses = posts.stream().map(post -> this.mapperService.forResponse()
                .map(post, ListPostResponse.class))
                .collect(Collectors.toList());
        return responses;
    }
}
