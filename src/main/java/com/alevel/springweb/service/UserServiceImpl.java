package com.alevel.springweb.service;

import com.alevel.springweb.UserRepository;
import com.alevel.springweb.converter.UserConverter;
import com.alevel.springweb.dto.User;
import com.alevel.springweb.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public void createUser(User user) {
        UserModel userModel = userConverter.toModel(user);

        userRepository.save(userModel);
    }

    @Override
    public List<User> getAll() {
        List<UserModel> all = userRepository.findAll();
        List<User> dtos = new ArrayList<>();
        for (UserModel model : all) {
            dtos.add(userConverter.toDto(model));
        }
        return dtos;
    }

    @Override
    public User getByName(String name) {
        UserModel userModel = userRepository.findByName(name);

        return userConverter.toDto(userModel);
    }

    @Override
    @Transactional
    public void deleteUser(String name) {
        userRepository.deleteByName(name);
    }

    @Override
    public List<User> findByGender(String gender) {
        List<UserModel> userModels = userRepository.findAllByGender(gender);
        List<User> dtos = new ArrayList<>();
        for (UserModel model : userModels) {
            dtos.add(userConverter.toDto(model));
        }
        return dtos;
    }

    @Override
    public List<User> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public User update(User user) {
        int id = userRepository.findByName(user.getName()).getId();
        UserModel userModel = userConverter.toModel(user);
        userModel.setId(id);
        userRepository.save(userModel);

        return user;
    }
}
