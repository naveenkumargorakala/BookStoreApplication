package com.example.bookstoreproject.service;

import com.example.bookstoreproject.dto.UserDto;
import com.example.bookstoreproject.model.UserEntity;

import java.util.List;

public interface iUserService {
    String register(UserDto dto);
    UserEntity getByEmail(String email, String token);
    List<UserEntity> allUsers();

    UserEntity retrieve(String token);

    UserEntity updateUser(UserDto userDto, String email, String token);

    String deleteUser(int id, String token);

    String login(String email, String password);

    String forgotPassword(String email,String password);

    String changePassword(String email, String oldPassword, String newPassword);
}
