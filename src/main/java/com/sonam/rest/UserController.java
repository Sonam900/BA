package com.sonam.rest;

import com.sonam.entity.User;
import com.sonam.payLoad.LoginDto;
import com.sonam.payLoad.UserDto;
import com.sonam.service.UserService;
import com.sonam.service.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PreAuthorize("permitAll()")
    @PostMapping("/post")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User createdUser = userServiceImpl.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/userLogin")
    public ResponseEntity<Map<String, String>> userLogin(@RequestBody LoginDto loginDto) {
    	String login = userServiceImpl.userLogin(loginDto.getName(), loginDto.getPassword());
    	String message ="Message";
    	Map<String, String> response = new HashMap<>();
    	response.put(message, login);
		return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PreAuthorize("permitAll()")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceImpl.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/{uid}")
    public ResponseEntity<User> getUserById(@PathVariable long uid) {
        User user = userServiceImpl.getUserById(uid);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{uid}")
    public ResponseEntity<String> updateUser(@PathVariable long uid, @RequestBody UserDto updatedUserData) {
        boolean updated = userServiceImpl.updateUser(uid, updatedUserData);
        if (updated) {
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<String> deleteUser(@PathVariable long uid) {
        boolean deleted = userServiceImpl.deleteUser(uid);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
