package com.globalopencampus.parkourapi.dto.mapper;

import com.globalopencampus.parkourapi.dto.model.UserDto;
import com.globalopencampus.parkourapi.model.User;

public class UserMapper {
    public static User maptoUser(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setRoles(userDto.roles());

        return user;
    }
}
