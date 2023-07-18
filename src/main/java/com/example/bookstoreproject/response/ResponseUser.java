package com.example.bookstoreproject.response;

import com.example.bookstoreproject.model.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseUser {
    private String message;
    private Object object;
    private List list;

    public ResponseUser(String user, String message) {
        this.message = message;
        this.object = user;
    }

    public ResponseUser(List<UserEntity> userList, String message) {
        this.message = message;
        this.list = userList;
    }

    public ResponseUser(UserEntity user, String message) {
        this.object = user;
        this.message =message;
    }

    public ResponseUser(String message, List<String> errorList) {
        this.message = message;
        this.list=errorList;
    }
}
