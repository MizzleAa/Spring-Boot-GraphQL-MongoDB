package com.sample.graphql;

import java.util.Optional;

import com.sample.domain.entity.User;
import com.sample.payload.request.CreateUser;
import com.sample.payload.request.DeleteUser;
import com.sample.payload.request.UpdateUser;
import com.sample.repository.UserRepository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver{
    
    private final UserRepository userRepository;

    public User create(CreateUser createUser){
        User user = User.builder()
            .email(createUser.getEmail())
            .password(createUser.getPassword())
            .name(createUser.getName())
            .age(createUser.getAge())
            .build();
        userRepository.save(user);
        log.info("user={}",user);
        return user;
    }

    public Boolean delete(DeleteUser deleteUser){
        Optional<User> user = userRepository.findByEmail(deleteUser.getEmail());
        Assert.isNull(user.isPresent(), "해당 유저는 존재하지 않습니다.");
        userRepository.deleteAllByEmail(user.get().getEmail());
        return true;
    }

    public User update(UpdateUser updateUser){
        Optional<User> user = userRepository.findByEmail(updateUser.getEmail());
        Assert.isNull(user.isPresent(), "해당 유저는 존재하지 않습니다.");
        user.get().update(updateUser.getName(), updateUser.getAge());
        userRepository.save(user.get());
        return user.get();
    }

}
