package com.globalopencampus.parkourapi.controller;

import com.globalopencampus.parkourapi.dto.mapper.UserMapper;
import com.globalopencampus.parkourapi.dto.model.UserDto;
import com.globalopencampus.parkourapi.model.User;
import com.globalopencampus.parkourapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')")
    @GetMapping("/{userId}")
    User get(@PathVariable Long userId){
        return this.userService.get(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_MANAGER') or hasRole('ROLE_USER')")
    @PostMapping()
    User add(@RequestBody UserDto userDto){
        // -- Check username already exists
        this.userService.getByUsername(userDto.username())
                .ifPresent(user -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                });

        User userToAdd = UserMapper.maptoUser(userDto);
        return this.userService.add(userToAdd)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_MANAGER')")
    @PutMapping("/{userId}")
    User update(@PathVariable Long userId, @RequestBody UserDto userDto){
        // -- Check if user is found in DB
        User existingUser = this.userService.get(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        User userToUpdate = UserMapper.maptoUser(userDto);
        userToUpdate.setId(existingUser.getId());
        userToUpdate.setCreatedDate(existingUser.getCreatedDate());

        return this.userService.update(userToUpdate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    }

    /*
    galad23 -> ROLE USER
    galad233 -> ROLE USER, MANAGER
    galad234 -> ROLE MANAGER
    galad235 -> ADMINISTRATOR
     */

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @DeleteMapping("/{userId}")
    ResponseEntity delete(@PathVariable Long userId){
        // -- Check if user is found in DB
        User existingUserToDelete = this.userService.get(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        this.userService.delete(existingUserToDelete);

        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_MANAGER')")
    @GetMapping()
    List<User> getAll(){
        return this.userService.getAll();
    }
}
