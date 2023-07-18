package com.example.bookstoreproject.model;

import com.example.bookstoreproject.dto.LoginDto;
import com.example.bookstoreproject.dto.UserDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue
    private int userID;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private Date date;
    private String password;

    public UserEntity(UserDto userDto) {
        this.firstName =userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.address = userDto.getAddress();
        this.date = userDto.getDate();
        this.password = userDto.getPassword();
    }

    public UserEntity(LoginDto loginDto) {
        this.email =loginDto.getEmail();
        this.password = loginDto.getPassword();
    }

}
