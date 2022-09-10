package com.example.springbootproject.api;

import com.example.springbootproject.domain.dto.AuthDto;
import com.example.springbootproject.domain.dto.HttpResponseDto;
import com.example.springbootproject.domain.model.User;
import com.example.springbootproject.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/user")
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody @Valid User userPayload){
        User user = userService.createUser(userPayload);
        return new ResponseEntity<>(new HttpResponseDto(true, 200, "Create User", user), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public void login(@RequestBody AuthDto authDto){}

    @PostMapping(value = "/{id}/role/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addRole(@PathVariable Long id, @PathVariable String role){
        User user = userService.addRole(id, role);
        return new ResponseEntity<>(new HttpResponseDto(true, 200, "Add role successful", user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/role/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeRole(@PathVariable Long id, @PathVariable String role){
        User user = userService.removeRole(id, role);
        return new ResponseEntity<>(new HttpResponseDto(true, 200, "Remove role successful", user), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(){
        return null;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(){
        return null;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(){
        return null;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer pageNumber,
                                    @RequestParam(required = false) Integer pageSize){
        Page<User> userPage = userService.getAll(pageNumber, pageSize);
        return new ResponseEntity<>(new HttpResponseDto(true, 200, "Get All", userPage), HttpStatus.OK);
    }

}
