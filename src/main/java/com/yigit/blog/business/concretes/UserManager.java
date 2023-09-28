package com.yigit.blog.business.concretes;

import com.yigit.blog.business.abstracts.UserService;
import com.yigit.blog.business.rules.UserBusinessRules;
import com.yigit.blog.core.utils.modelMapper.ModelMapperService;
import com.yigit.blog.dataAccess.abstracts.IUserRepository;
import com.yigit.blog.dto.requests.CreateUserRequest;
import com.yigit.blog.dto.responses.ListUserResponse;
import com.yigit.blog.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private IUserRepository userRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules userBusinessRules;
    @Override
    public List<ListUserResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<ListUserResponse> userResponses = users.stream().map(user -> this.mapperService.forResponse()
                .map(user, ListUserResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }

    @Override
    public void deleteById(int id) {
        this.userBusinessRules.checkIfUserId(id);
        this.userRepository.deleteById(id);
    }

    @Override
    public CreateUserRequest add(CreateUserRequest userRequest) {
        this.userBusinessRules.checkIfUserUsername(userRequest.getUsername());
        User user = this.mapperService.forRequest().map(userRequest,User.class);
        this.userRepository.save(user);
        return userRequest;
    }
}
