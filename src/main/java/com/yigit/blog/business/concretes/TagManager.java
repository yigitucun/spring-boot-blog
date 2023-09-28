package com.yigit.blog.business.concretes;

import com.yigit.blog.business.abstracts.TagService;
import com.yigit.blog.business.rules.TagBusinessRules;
import com.yigit.blog.core.utils.modelMapper.ModelMapperService;
import com.yigit.blog.dataAccess.abstracts.ITagRepository;
import com.yigit.blog.dto.requests.CreateTagRequest;
import com.yigit.blog.dto.responses.ListTagResponse;
import com.yigit.blog.entities.concretes.Tag;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TagManager implements TagService {

    private ITagRepository tagRepository;
    private ModelMapperService mapperService;
    private TagBusinessRules tagBusinessRules;

    @Override
    public List<ListTagResponse> getAll() {
        List<Tag> tags = this.tagRepository.findAll();
        List<ListTagResponse> tagResponses = tags.stream().map(tag -> this.mapperService.forResponse()
                .map(tag, ListTagResponse.class))
                .collect(Collectors.toList());
        return tagResponses;
    }

    @Override
    public void deleteById(int id) {
        this.tagBusinessRules.checkIfTagId(id);
        this.tagRepository.deleteById(id);
    }

    @Override
    public CreateTagRequest add(CreateTagRequest tagRequest) {
        Tag tag = this.mapperService.forRequest().map(tagRequest, Tag.class);
        this.tagRepository.save(tag);
        return tagRequest;
    }
}
