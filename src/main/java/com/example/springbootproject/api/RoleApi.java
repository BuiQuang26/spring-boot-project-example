package com.example.springbootproject.api;

import com.example.springbootproject.domain.dto.HttpResponseDto;
import com.example.springbootproject.domain.model.Role;
import com.example.springbootproject.repositories.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleApi {

    private final RoleRepository roleRepository;

    public RoleApi(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Role role){
        Role r = roleRepository.save(role);
        return new ResponseEntity<>(new HttpResponseDto(true, 200, "Create role success", r), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable String role){
        roleRepository.deleteById(role);
        return new ResponseEntity<>(new HttpResponseDto(true, 200, "Delete successFul", null), HttpStatus.OK);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(){
        List<Role> roles = roleRepository.findAll();
        return new ResponseEntity<>(new HttpResponseDto(true, 200, "Get role", roles), HttpStatus.OK);
    }

}
