package com.alevel.springweb.service;

import com.alevel.springweb.dto.User;
import com.alevel.springweb.model.UserModel;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    void createUser(User user);

    List<User> getAll();

    User getByName(String name);

    void deleteUser(String name);

    List<User> findByGender(String gender);

    List<User> findByDate(LocalDate date);

    User update(User user);
}
