package com.alevel.springweb;

import com.alevel.springweb.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByName(String name);

    @Modifying
    void deleteByName(String name);

    List<UserModel> findAllByGender(String gender);
}
