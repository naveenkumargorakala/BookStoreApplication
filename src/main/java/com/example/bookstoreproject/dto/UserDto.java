package com.example.bookstoreproject.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDto {

    @Pattern(regexp = "^[A-Z][a-z]{2,}$",message = "You are Entered Wrong Format")
    private String firstName;
    @Pattern(regexp = "^[A-Z][a-z]{2,}$",message = "You are Entered Wrong Format")
    private String lastName;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "You are Entered Wrong Format of Email")
    private String email;
    private String address;
    private Date date;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message = "must satisfy all the things")
    private String password;
}
