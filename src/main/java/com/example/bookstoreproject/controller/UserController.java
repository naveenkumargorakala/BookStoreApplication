package com.example.bookstoreproject.controller;

import com.example.bookstoreproject.dto.UserDto;
import com.example.bookstoreproject.model.UserEntity;
import com.example.bookstoreproject.response.ResponseUser;
import com.example.bookstoreproject.service.iUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    iUserService iUserService;

    //register user to bookStore
    @PostMapping("/register")
    public ResponseEntity<ResponseUser> register(@Valid @RequestBody UserDto dto){
        String user = iUserService.register(dto);
        ResponseUser responseUser = new ResponseUser(user,"registered");
        return new ResponseEntity<>(responseUser,HttpStatus.CREATED);
    }

    //get by email
    @GetMapping("/getbyemail/{email}/{token}")
    public ResponseEntity<ResponseUser> getByEmail(@PathVariable String email,@PathVariable String token){
        UserEntity user = iUserService.getByEmail(email,token);
        ResponseUser responseUser = new ResponseUser(user,"Data");
        return new ResponseEntity<>(responseUser,HttpStatus.CREATED);
    }

    //get all persons data
    @GetMapping("/getallusers")
    public ResponseEntity<List<ResponseUser>> getAllUsers(){
        List<UserEntity> userList= iUserService.allUsers();
        ResponseUser responseUser = new ResponseUser(userList,"All Users in BookStore");
        return new ResponseEntity<>(responseUser.getList(), HttpStatus.OK);
    }

    //retrieve person details by token
    @GetMapping("/retrieve/{token}")
    public ResponseEntity<ResponseUser> retrieve(@PathVariable String token){
        UserEntity user = iUserService.retrieve(token);
        ResponseUser responseUser = new ResponseUser(user,"User details, get by token");
        return new ResponseEntity<>(responseUser,HttpStatus.FOUND);
    }

    //update user details
    @PutMapping("/updatebytoken/{email}/{token}")
    public ResponseEntity<ResponseUser> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable String email,@PathVariable String token){
        UserEntity user = iUserService.updateUser(userDto,email,token);
        ResponseUser responseUser = new ResponseUser(user,"Details are Updated");
        return new ResponseEntity<>(responseUser,HttpStatus.OK);
    }

    //delete user details
    @DeleteMapping("/deletebytoken/{id}/{token}")
    public ResponseEntity<ResponseUser> deleteUser(@PathVariable int id,@PathVariable String token){
        String message = iUserService.deleteUser(id,token);
        ResponseUser responseUser = new ResponseUser(message,"Remove User Details");
        return new ResponseEntity<>(responseUser,HttpStatus.OK);
    }

    //user login
    @PostMapping("/login/{email}/{password}")
    public ResponseEntity<ResponseUser> login(@PathVariable String email,@PathVariable String password){
        String loginUser = iUserService.login(email,password);
        ResponseUser responseUser = new ResponseUser(loginUser,"Login");
        return new ResponseEntity<>(responseUser,HttpStatus.ACCEPTED);
    }

    //Forgot password
    @PutMapping("/forgotpassword/{email}")
    public ResponseEntity<ResponseUser> forgotPassword( @PathVariable String email,@RequestParam String password){
        String message = iUserService.forgotPassword(email,password);
        ResponseUser responseUser = new ResponseUser(message,"Forgot Password");
        return new ResponseEntity<>(responseUser,HttpStatus.ACCEPTED);
    }

    //Change Password
    @PutMapping("/changepassword/{email}/{oldPassword}")
    public ResponseEntity<ResponseUser> changePassword(@PathVariable String email,@PathVariable String oldPassword,@RequestParam String newPassword){
        String message = iUserService.changePassword(email,oldPassword,newPassword);
        ResponseUser responseUser = new ResponseUser(message,"Password Change");
        return new ResponseEntity<>(responseUser,HttpStatus.ACCEPTED);
    }
}
