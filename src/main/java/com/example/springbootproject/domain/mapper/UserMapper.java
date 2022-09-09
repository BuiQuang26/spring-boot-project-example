package com.example.springbootproject.domain.mapper;

import com.example.springbootproject.domain.dto.UserDto;
import com.example.springbootproject.domain.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto UserToUserDto(User user);
    List<UserDto> ListUserToListUserDto(List<User> userList);

}
