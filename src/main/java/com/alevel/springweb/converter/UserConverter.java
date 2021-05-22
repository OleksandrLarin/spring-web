package com.alevel.springweb.converter;

import com.alevel.springweb.dto.User;
import com.alevel.springweb.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public UserModel toModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setName(user.getName());
        userModel.setAddress(user.getAddress());
        userModel.setEmail(user.getEmail());
        userModel.setGender(user.getGender());
        userModel.setDateOfBirth(user.getDateOfBirth());

        return userModel;
    }

    public User toDto(UserModel userModel) {
        User user = new User();
        user.setName(userModel.getName());
        user.setAddress(userModel.getAddress());
        user.setEmail(userModel.getEmail());
        user.setGender(userModel.getGender());
        user.setDateOfBirth(userModel.getDateOfBirth());

        return user;
    }
}
